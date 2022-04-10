<template>
  <v-container>

    <RecipeBase title="レシピ編集画面"></RecipeBase>

    <v-row  cols="20">
      <v-col class="justify-left">
      <v-btn router-link :to="'/recipeList'" class = "start">戻る</v-btn>
      </v-col>

      <v-col class="justify-center">
        <v-btn color="primary" @click="update()">登録</v-btn>
      </v-col>
    </v-row>
  
  </v-container>
</template>

<script>
import axios from 'axios'
import RecipeBase from './RecipeBase'

export default {
  name: 'RecipeUpdate',
  
  // **************************************************************************
  // * データ  
  // **************************************************************************
  data: function() {
    return {
    }
  },
  
  // **************************************************************************
  // * 初期処理
  // **************************************************************************
  mounted() {
    this.recipe = {
      customer: {},
      ingredients: [{}],
      processes: [{}]
    }
    this.searchRecipeByID()
  },
  
  // **************************************************************************
  // * コンポーネント
  // **************************************************************************
  components: {
    RecipeBase
  },
  
  // **************************************************************************
  // * メソッド
  // **************************************************************************
  methods: {
      
    // ========================================================================
    // IDで検索
    // ========================================================================
    searchRecipeByID: function() {
    
      axios.get('http://localhost:8080/recipes/' + this.$route.params.id)
        .then(response => {
            this.recipe = response.data
            console.log(JSON.stringify(this.recipe))
        })
        .catch( e => {
          console.log(e)
        })
    },
  
    // ========================================================================
    // 更新
    // ========================================================================
    update: function() {
    
      this.recipe.customer = this.user
      axios.put('http://localhost:8080/recipes/' + this.$route.params.id, this.recipe)
      .then(response => {
        this.recipe = response.data
        console.log(JSON.stringify(this.recipe))
      })
    },
  },
  
  // **************************************************************************
  // * 算出プロパティ
  // **************************************************************************
  computed: {
  
    // ========================================================================
    // user
    // ========================================================================
    user: {
      get () {
        return this.$store.state.user
      },
      set (value) {
        this.$store.commit('serUser', value)
      }
    },
  
    // ========================================================================
    // recipe
    // ========================================================================
    recipe: {
      get () {
        return this.$store.state.recipe
      },
      set (value) {
        this.$store.commit('setRecipe', value)
      }
    },
  },
}
</script>