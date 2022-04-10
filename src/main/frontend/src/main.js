import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import router from './router'
import store from './store'

// Firebase
import firebase from 'firebase/app'
import 'firebase/app'
import 'firebase/firestore'
import 'firebase/auth'
import util from '@/mixins/util'

Vue.use(VueAxios, axios)

Vue.config.productionTip = false

// Firebase configuration
const firebaseConfig = {
  apiKey: "AIzaSyDsrXyXp_Lkz8cwFFLhPt4nhkg2wM3cgck",
  authDomain: "project-recipe-cb60f.firebaseapp.com",
  projectId: "project-recipe-cb60f",
  storageBucket: "project-recipe-cb60f.appspot.com",
  messagingSenderId: "518553161844",
  appId: "1:518553161844:web:a3bb91d512bc7d11968121",
  measurementId: "G-YKDN7ZHCGP"
};

// Initialize Firebase
firebase.initializeApp(firebaseConfig);

Vue.mixin(util)

new Vue({
  vuetify,
  router,
  store,
  render: h => h(App)
}).$mount('#app')
