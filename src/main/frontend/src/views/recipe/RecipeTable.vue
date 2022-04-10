<template>
  <v-container>

    <v-row>
      <v-col cols="10">
        <v-data-table :headers="headers" :items="recipe">

        <template v-slot:[`item.id`]="{item}">
            <router-link :to="{name: 'recipeUpdate', params: {id: item.id}}">
              {{ item.id }}
            </router-link>
          </template>

          <template v-slot:[`item.delete`]="{item}">
            <v-btn small color="error" @click="deleteRecipe(item.id)">
              delete
            </v-btn>
          </template>

        </v-data-table>
      </v-col>
    </v-row>
    
  </v-container>
</template>

<script>
import axios from 'axios';

export default {
  name: 'RecipeTable',

  // **************************************************************************
  // * データ
  // **************************************************************************
  data: function() {
    return {
        headers: [
            { 
            text: 'ID', 
            value: 'id' 
            },
            {
            text: 'レシピ名',
            value: 'name',
            },
            { text: '作成者', 
            value: 'customer.name' 
            },
            {
            text:'削除',
            value:'delete',
            sortable:false
            }
        ],
        recipe: [],
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
            this.recipe = response.data
            console.log(JSON.stringify(this.recipe))
        })
        .catch( e => {
          console.log(e)
        })
    },

    // ========================================================================
    // 行削除
    // ========================================================================
    deleteRecipe: function(id) {
    
      axios.delete('http://localhost:8080/recipes/' + id)
      .then(response => {
        console.log(response)
        this.searchRecipe()
      })

   },

  },
  

}
</script>