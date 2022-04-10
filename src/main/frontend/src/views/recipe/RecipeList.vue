<template>
  <v-container>

    <h2>レシピ一覧</h2>

    <v-text-field label="レシピ名" v-model="searchName"></v-text-field>
    <v-btn elevation="2" @click="searchRecipeByName()">検索</v-btn>
    <br><br>

    <RecipeTable></RecipeTable>

  </v-container>
</template>

<script>
import axios from 'axios'
import RecipeTable from './RecipeTable'

export default {
  name: 'RecipeList',
  props: {
    msg: String
  },
  
  // **************************************************************************
  // * データ
  // **************************************************************************
  data: function() {
    return {
      recipes: [],
      searchName: "",
    }
  },
  
  // **************************************************************************
  // * 初期処理
  // **************************************************************************
  mounted() {
  },
  
  // **************************************************************************
  // * コンポーネント
  // **************************************************************************
  components: {
    RecipeTable
  },
  
  // **************************************************************************
  // * メソッド
  // **************************************************************************
  methods: {
      
    // ========================================================================
    // IDで検索
    // ========================================================================
    searchRecipeByName: function() {
    
      axios.get('http://localhost:8080/recipes/' + this.searchName)
        .then(response => {
            this.recipe = response.data
            console.log(JSON.stringify(this.recipe))
        })
        .catch( e => {
          console.log(e)
        })
    },
  },
}
</script>