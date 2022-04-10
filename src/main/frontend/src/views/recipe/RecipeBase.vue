<template>
  <v-container>

    <h2>{{ title }}</h2>

    <v-row>
      <v-col cols="8" sm="12" md="6">
        <v-text-field label="レシピ名" v-model="recipe.name">
        </v-text-field>
      </v-col>
    </v-row>

    <v-row dense>
      <v-col cols="8" sm="12" md="6">
        <v-text-field label="レシピ画像" v-model="recipe.nameImageUrl">
        </v-text-field>
      </v-col>
    </v-row>

    <v-row dense>
      <v-col cols="2" sm="2" md="1">
        <v-text-field label="何人分か" v-model="recipe.numberOfPeople">
        </v-text-field>
      </v-col>
    </v-row>
        
    <v-row>
      <v-col cols="1">
        <h3>材料</h3>
      </v-col>
      <v-col cols="2">
        <v-btn @click="addIngredient">追加する</v-btn>
      </v-col>
    </v-row>
    <div
      v-for="(ingredient, index) in recipe.ingredients" :key="`first-${ingredient.id}`">
      <v-row dense>
        <v-col cols="10" sm="10" md="5">
          <v-text-field label="材料名" v-model="recipe.ingredients[index].name">
          </v-text-field>
        </v-col>
        <v-col cols="4" sm="4" md="2">
          <v-text-field label="量"
            v-model="recipe.ingredients[index].amount">
          </v-text-field>
        </v-col>
        <v-col cols="2" sm="2" md="1">
          <v-text-field label="単位"
            v-model="recipe.ingredients[index].unit">
          </v-text-field>
        </v-col>
      </v-row>
    </div>
    <br>

    <v-row>
      <v-col cols="1">
        <h3>手順</h3>
      </v-col>
      <v-col cols="2">
        <v-btn @click="addProcesses">追加する</v-btn>
      </v-col>
    </v-row>
    <div v-for="(processes, index) in recipe.processes" :key="`second-${processes.id}`">
      <v-row dense>
        <v-col cols="8" sm="16" md="8">
          <v-text-field label="手順"  v-model="recipe.processes[index].text">
          </v-text-field>
        </v-col>
      </v-row>
    </div>
    <br><br>

  </v-container>
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
  // * コンポーネント
  // **************************************************************************
  components: {
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