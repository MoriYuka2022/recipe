import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    customer: {},
    recipe: {
      customer: {},
      ingredients:[{}],
      processes:[{}]
    },
    user: {
      email: "test3@gmail.com",
      password: "yuka1014"
}
  },
  getters: {
  },
  mutations: {
    setState(state, {name, value}) {
      state[name] = value
    },

    // いらなくなる
    setCustomer (state, customer) {
      state.customer = customer
    },
    setRecipe (state, recipe) {
      state.recipe = recipe
    },
    setUser (state, user) {
      state.user = user
    }
  },
  actions: {
  },
  modules: {
  }
})
