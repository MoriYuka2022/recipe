<template>
  <div>
    <h2>{{ title }}</h2>
    
    <div>
      レシピ名
        <input type="text" v-model="recipe.name"><br>
        
      レシピ画像
        <input type="text" v-model="recipe.nameImageUrl"><br>
        
      材料<button @click="addIngredient">+</button>
        <div v-for="(ingredient, index) in recipe.ingredients" :key="ingredient.id">
          <input type="text" v-model="recipe.ingredients[index].name">
        </div>
        
      手順<button @click="addProcesses">+</button>
        <div v-for="(processes, index) in recipe.processes" :key="processes.id">
          <input type="text" v-model="recipe.processes[index].text">
        </div><br>
    </div>
  </div>
</template>

<script>

export default {
  name: 'RecipeBase',
  
  // **************************************************************************
  // * 引数
  // **************************************************************************
  props: {
    title: String
  },
  
  // **************************************************************************
  // * メソッド
  // **************************************************************************
  methods: {
  
    addIngredient: function(){
    
      this.recipe.ingredients.push({
      })
    },
    
    addProcesses: function(){
    
      this.recipe.processes.push({
      })
    },
  },
  
  // **************************************************************************
  // * 算出プロパティ
  // **************************************************************************
  computed: {
  
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