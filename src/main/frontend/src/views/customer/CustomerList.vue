<template>
  <div>
    <button @click="searchCustomers()" class="btn btn-primary">検索</button><br><br>
    <table  class="table table-bordered table-hover">
      <thead>
        <tr>
          <th width="20%">id</th>
          <th width="50%">名前</th>
          <th width="20%">レシピ</th>
          <th width="10%">削除</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(customer, index) in customers" :key="index">
          <td><router-link :to="{name: 'customerUpdate', params: {id: customer.id}}">{{ customer.id }}</router-link></td>
          <td>{{ customer.name }}</td>
          <td><router-link :to="{name: 'recipeLIst', params: {id: customer.id}}">レシピ</router-link></td>
          <td><button @click="deleteCustomer(customer.id)" class="btn btn-primary">削除</button></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios'

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

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
