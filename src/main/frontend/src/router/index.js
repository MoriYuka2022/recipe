import Vue from 'vue'
import VueRouter from 'vue-router'
import firebase from 'firebase/app'

import HomeView from '../views/HomeView.vue'
import RecipeLogin from '../views/login/RecipeLogin.vue'
import RecipeLogout from '../views/login/RecipeLogout.vue'
import RecipeSignUp from '../views/login/RecipeSignUp.vue'
import RecipeList from '../views/recipe/RecipeList.vue'
import RecipeCreate from '../views/recipe/RecipeCreate.vue'
import RecipeUpdate from '../views/recipe/RecipeUpdate.vue'
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
    path: '/recipeUpdate',
    name: 'recipeUpdate',
    component: RecipeUpdate
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

// ========================================================================
// 画面遷移前処理
// ========================================================================
router.beforeEach((to, from, next) => {

  console.log(firebase.auth().currentUser)
  console.log(to.path)

  // ログイン画面の場合
  if (to.path == '/recipeLogin') {
    next()
    return
  }

  // 未ログインの場合
  if (!firebase.auth().currentUser) {
    next({
      path: '/recipeLogin',
      query: { redirect: to.fullPath }
    })
    return
  }

  next()
})

export default router
