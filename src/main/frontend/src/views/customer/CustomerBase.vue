<template>
  <div>
    <h2>{{ title }}</h2>
    
    <div>
      顧客名
      <input type="text" v-model="customer.name"><br><br>
    </div>
  </div>
</template>

<script>

export default {
  name: 'CustomerBase',
  
  // **************************************************************************
  // * 引数
  // **************************************************************************
  props: {
    title: String
  },
  
  // **************************************************************************
  // * メソッド
  // **************************************************************************
  methods: {
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
