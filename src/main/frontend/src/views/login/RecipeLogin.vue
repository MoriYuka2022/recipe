<template>
  <v-container>

    <input type="email" v-model="user.email"><br>
    <input type="password" v-model="user.password"><br>
    <button  @click="login" class="firebaseui-idp-button">
          <span class="firebaseui-idp-text firebaseui-idp-text-long">メールでログイン</span>
    </button><br><br>
    <ul>
      <li>
        初めてのご利用ですか？
      </li>
      <li>
        <router-link to="/recipeSignUp">
          アカウントを作成する
        </router-link>
      </li>
    </ul>
    
  </v-container>
</template>

<script>

import axios from 'axios'
import firebase from "firebase/app";

export default {
  name: 'RecipeLogin',
    
  // **************************************************************************
  // * メソッド
  // **************************************************************************
  methods: {
 
    // ========================================================================
    // ログイン時処理
    // ========================================================================
    login: function(){
    
      //firebase signIn
      firebase.auth().signInWithEmailAndPassword(this.user.email, this.user.password)
        .then((userCredential) => {
        this.user.id = userCredential.user.uid
    
      //store.userの設定
      axios.get('http://localhost:8080/customers/' + this.user.id)
      .then(response => {
        this.user = response.data
        console.log(JSON.stringify(this.user))
      })
      
      //Home画面に遷移
      this.$router.push('/')
    
  })
  .catch((error) => {
    console.log(error)
  })
    }
  },
}
</script>
