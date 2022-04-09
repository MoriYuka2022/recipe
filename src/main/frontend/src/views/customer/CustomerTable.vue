<template>
    <v-container>
        <v-row>
            <v-col cols="10">
                <v-data-table
                :headers="headers"
                :items="customers"
                >

                    <template v-slot:[`item.recipe`]>
                        レシピ
                    </template>

                    <template v-slot:[`item.delete`]>
                        <v-btn
                        small
                        color="error"
                        @click="deleteCustomer(customer.id)"
                        >
                            delete
                        </v-btn>
                    </template>
                </v-data-table>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>

import axios from 'axios';

export default {
  name: 'CustomerTable',

  // **************************************************************************
  // * データ
  // **************************************************************************
  data: function() {
    return {
        headers: [
            { 
            text: 'ID', 
            value: 'id' 
            },
            {
            text: '名前',
            value: 'name',
            },
            { text: 'レシピ', 
            value: 'recipe' 
            },
            {
            text:'削除',
            value:'delete',
            sortable:false
            }
        ],
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
        .catch( e => {
          console.log(e)
        })
        .finally(()=>{
          console.log("通信完了")
        })
    },

    // ========================================================================
    // 行削除
    // ========================================================================
   deleteCustomer: function(id) {
console.log(JSON.stringify(id))
        confirm('削除しますか') 
    
        axios.delete('http://localhost:8080/customers/' + id)
            .then(response => {
            console.log(response)
            this.searchCustomers()
        })
   },

  },
}
</script>