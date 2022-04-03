<template>
  <div>
    <button @click="searchRecipe()" class="btn btn-primary">検索</button><br><br>
    <table  class="table table-bordered table-hover">
      <thead>
        <tr>
          <th width="10%">id</th>
          <th width="60%">レシピ名</th>
          <th width="20%">作成者</th>
          <th width="10%">削除</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(recipe, index) in recipes" :key="recipe.id">
          <td>{{ recipes[index].id }}</td>
          <td>{{ recipes[index].name }}</td>
          <td>{{ recipes[index].customer.name }}</td>
          <td><button @click="deleteRecipe(recipe.id)" class="btn btn-primary">削除</button></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>



<script>
import axios from 'axios'

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
    }
  },
  
  // **************************************************************************
  // * 初期処理
  // **************************************************************************
  mounted() {
    this.searchRecipe()
  },
  
  // **************************************************************************
  // * メソッド
  // **************************************************************************
  methods: {
  
    // ========================================================================
    // 検索
    // ========================================================================
    searchRecipe: function() {
    
      axios.get('http://localhost:8080/recipes/')
      .then(response => {
        this.recipes = response.data
        console.log(JSON.stringify(this.recipes))
      })
    },
    
    // ========================================================================
    // 削除
    // ========================================================================
    deleteCustomer: function(id) {
    
      axios.delete('http://localhost:8080/recipes/' + id)
      .then(response => {
        console.log(response)
        this.searchRecipe()
      })
    },
  },
}
</script>