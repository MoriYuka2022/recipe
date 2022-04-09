<template>
  <v-container>

    <h2>ユーザー新規登録</h2>

    <v-row>
      <v-col
        cols="12"
        sm="6"
        md="3"
      >
        <v-text-field
          label="ユーザー名"
          v-model="user.name"
        ></v-text-field>
      </v-col>
    </v-row>

    <v-row>
      <v-col
        cols="12"
        sm="6"
        md="3"
      >
        <v-text-field
          label="メールアドレス"
          v-model="user.email"
        ></v-text-field>
      </v-col>
    </v-row>

    <v-row>
      <v-col
        cols="12"
        sm="6"
        md="3"
      >
        <v-text-field
          label="パスワード"
          v-model="user.password"
        ></v-text-field>
      </v-col>
    </v-row>

    <v-btn elevation="2" @click="signUp">メールで登録</v-btn>
    
  </v-container>
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
