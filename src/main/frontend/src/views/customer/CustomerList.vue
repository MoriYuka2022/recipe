<template>
  <v-container>

    <h2>顧客一覧</h2>
    
    <v-btn elevation="2" @click="searchCustomers()">検索</v-btn>

    <CustomerTable></CustomerTable>

  </v-container>
</template>

<script>
import axios from 'axios'
import CustomerTable from './CustomerTable'

export default {
  name: 'CustomerList',
  props: {
    msg: String
  },
  
  // **************************************************************************
  // * データ
  // **************************************************************************
  data: function() {
    return {
      customers: [],
    }
  },
  
  // **************************************************************************
  // * 初期処理
  // **************************************************************************
  mounted() {
    this.searchCustomers()
  },
  
  // **************************************************************************
  // * コンポーネント
  // **************************************************************************
  components: {
    CustomerTable
  },
  
  // **************************************************************************
  // * メソッド
  // **************************************************************************
  methods: {
  
    // ========================================================================
    // 検索
    // ========================================================================
    searchCustomers: function() {
    
      axios.get('http://localhost:8080/customers/')
      .then(response => {
        this.customers = response.data
        console.log(JSON.stringify(this.customers))
      })
    },
    
    // ========================================================================
    // 削除
    // ========================================================================
    deleteCustomer: function(id) {
    
      axios.delete('http://localhost:8080/customers/' + id)
      .then(response => {
        console.log(response)
        this.searchCustomers()
      })
    },
  },
}
</script>