import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import RecipeLogin from '../views/login/RecipeLogin.vue'
import RecipeLogout from '../views/login/RecipeLogout.vue'
import RecipeList from '../views/recipe/RecipeList.vue'
import RecipeCreate from '../views/recipe/RecipeCreate.vue'
import CustomerList from '../views/customer/CustomerList.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/recipeLogin',
    name: 'recipeLogin',
    component: RecipeLogin
  },
  {
    path: '/recipeLogout',
    name: 'recipeLogout',
    component: RecipeLogout
  },
  {
    path: '/recipeList',
    name: 'recipeList',
    component: RecipeList
  },
  {
    path: '/recipeCreate',
    name: 'recipeCreate',
    component: RecipeCreate
  },
  {
    path: '/customerList',
    name: 'customerList',
    component: CustomerList
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
