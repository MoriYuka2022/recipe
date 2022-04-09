<template>
  <div>

    <v-alert v-if="errorMsg" dense outlined type="error">{{ errorMsg }}</v-alert>

    <CustomerBase title="顧客編集画面"></CustomerBase>

    <button @click="update()" class="btn btn-primary">編集</button>
  </div>
</template>

<script>
import axios from 'axios'
import CustomerBase from './CustomerBase'

export default {
  name: 'CustomerUpdate',

  // **************************************************************************
  // * データ  
  // **************************************************************************
  data: function() {
    return {
      errorMsg: "",
    }
  },
  
  // **************************************************************************
  // * 算出プロパティ
  // **************************************************************************
  computed: {
  
    // **************************************************************************
    // * customer
    // **************************************************************************
    customer: {
      get () {
        return this.$store.state.customer
      },
      set (value) {
        this.$store.commit('setCustomer', value)
      }
    },
  },
  
  // **************************************************************************
  // * 初期処理
  // **************************************************************************
  mounted() {
    this.get()
  },
  
  // **************************************************************************
  // * コンポーネント
  // **************************************************************************
  components: {
    CustomerBase
  },
  
  // **************************************************************************
  // * メソッド
  // **************************************************************************
  methods: {
  
    // ========================================================================
    // 取得
    // ========================================================================
    get: function() {
    
      axios.get('http://localhost:8080/customers/' + this.$route.params.id)
      .then(response => {
        this.customer = response.data
        console.log(JSON.stringify(this.customer))
      })
    },
  
    // ========================================================================
    // 更新
    // ========================================================================
    update: function() {
    
      axios.put('http://localhost:8080/customers/' + this.$route.params.id, this.customer)
      .then(response => {
        this.customer = response.data
        console.log(JSON.stringify(this.customer))
        this.$router.push('/customer/list')
      })
      .catch(error => {
        console.log(JSON.stringify(error.response))
        this.errorMsg = error.response.data.message
      })
    },
  },
}
</script>