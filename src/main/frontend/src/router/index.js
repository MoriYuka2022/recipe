import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import RecipeLogin from '../views/login/RecipeLogin.vue'
import RecipeLogout from '../views/login/RecipeLogout.vue'
import RecipeSignUp from '../views/login/RecipeSignUp.vue'
import RecipeList from '../views/recipe/RecipeList.vue'
import RecipeCreate from '../views/recipe/RecipeCreate.vue'
import CustomerList from '../views/customer/CustomerList.vue'
import CustomerUpdate from '../views/customer/CustomerUpdate.vue'

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
    path: '/recipeSignUp',
    name: 'recipeSignUp',
    component: RecipeSignUp
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
  },
  {
    path: '/customerUpdate/:id',
    name: 'customerUpdate',
    component: CustomerUpdate
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
