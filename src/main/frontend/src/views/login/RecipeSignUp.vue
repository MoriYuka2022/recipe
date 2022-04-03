<template>
  <div>
    ユーザー名
      <input type="name" v-model="user.name"><br>
    メールアドレス
      <input type="email" v-model="user.email"><br>
    パスワード
      <input type="password" v-model="user.password"><br>
    <button  @click="signUp">
      <span>メールで登録</span>
    </button>
  </div>
</template>

<script>

import axios from 'axios'
import firebase from "firebase/app";

export default {
  name: 'RecipeLogin',
  
  // **************************************************************************
  // * データ  
  // **************************************************************************
  data: function() {
    return {
    }
  },
  
  // **************************************************************************
  // * メソッド
  // **************************************************************************
  methods: {

    // ========================================================================
    // アカウント作成時処理
    // ========================================================================
    signUp: function(){

      // firebaseアカウント登録
      firebase.auth().createUserWithEmailAndPassword(this.user.email, this.user.password)
      .then((userCredential) => {
      
        // 登録に成功した場合、customerテーブルにuserを登録
        this.user.id = userCredential.user.uid
        axios.post('http://localhost:8080/customers/', this.user)
        .then(response => {
          this.user = response.data
          console.log(JSON.stringify(this.user))
          this.$router.push('/')
        })
      })
    }
  },
}
</script>
