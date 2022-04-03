<template>
  <div>
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
