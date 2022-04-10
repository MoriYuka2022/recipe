<template>
  <v-container>

    <h2>ユーザーログイン</h2><br>

    <v-row>
      <v-col cols="8" sm="6" md="3">
        <v-text-field label="メールアドレス" v-model="user.email">
        </v-text-field>
      </v-col>
    </v-row>

    <v-row dense>
      <v-col cols="8" sm="6" md="3">
        <v-text-field label="パスワード" v-model="user.password">
        </v-text-field>
      </v-col>
    </v-row>

    <v-btn elevation="2" @click="login">メールでログイン</v-btn>
    <br><br>

    <ul>
      <li>
        初めてのご利用ですか？
        <router-link to="/recipeSignUp">アカウントを作成する</router-link>
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
