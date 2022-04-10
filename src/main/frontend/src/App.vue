<template>
  <v-app>

    <v-navigation-drawer app v-model="drawer" clipped>
      <v-container>
        <v-list-item>
          <v-list-item-content>
            <v-list-item-title class="title grey--text text--darken-2">
              Menu
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-divider></v-divider>

        <v-list dense nav>
          <div v-for="(menu_list, index) in menu_lists" :key="index">
            <v-list-item v-if="menu_list.link" :to="menu_list.link">
              <v-list-item-icon>
                <v-icon>{{ menu_list.icon }}</v-icon>
              </v-list-item-icon>
              <v-list-item-content>
                <v-list-item-title>{{ menu_list.name }}</v-list-item-title>
              </v-list-item-content>
            </v-list-item>

            <v-list-group v-else
              :prepend-icon="menu_list.icon" no-action>
              <template v-slot:activator>
                <v-list-item-content>
                  <v-list-item-title>{{ menu_list.name }}</v-list-item-title>
                </v-list-item-content>
              </template>
              <v-list-item v-for="list in menu_list.lists" :key="list.name" :to="list.link">
                <v-list-item-content>
                  <v-list-item-title>{{ list.name }}</v-list-item-title>
                </v-list-item-content>
              </v-list-item>
            </v-list-group>
          </div>
        </v-list>
      </v-container>
    </v-navigation-drawer>

    <v-app-bar color="primary" dark app clipped-left>
      <v-app-bar-nav-icon @click="drawer=!drawer"></v-app-bar-nav-icon>
        <v-toolbar-title>Recipe</v-toolbar-title>
        <v-spacer></v-spacer>
      
        <v-toolbar-items>
          {{ user.name }}
          <v-menu offset-y>
            <template v-slot:activator="{on}">
              <v-btn v-on="on" text>Login<v-icon>mdi-menu-down</v-icon></v-btn>
            </template>
            <v-list>
              <v-list-item v-for="login in logins" :key="login.name" :to="login.link">
                <v-list-item-icon>
                  <v-icon>{{ login.icon }}</v-icon>
                </v-list-item-icon>
                <v-list-item-content>
                  <v-list-item-title>{{ login.name }}</v-list-item-title>
                </v-list-item-content>
              </v-list-item>
            </v-list>
          </v-menu>
        </v-toolbar-items>
    </v-app-bar>

    <v-main>
      <router-view />
    </v-main>

    <v-footer color="primary" dark app>
      © 2022 forest
    </v-footer>
  </v-app>
</template>

<script>
export default {
  data(){
    return{
      drawer: true,

      logins:[
        {
          name: 'ログイン',
          icon: 'mdi-account-arrow-left',
          link: '/recipeLogin'
        },
        {
          name: 'ログアウト',
          icon: 'mdi-account-arrow-right',
          link: '/recipeLogout'
        }
      ],

      menu_lists:[
        {
          name: 'レシピ',
          icon: 'mdi-chef-hat',
          lists:[
            {
              name:'レシピ一覧',
              link:'/recipeList'
            },
            {
              name:'レシピ登録',
              link:'/recipeCreate'
            }
            ]
        },
        {
          name: '顧客一覧',
          icon: 'mdi-account',
          link: '/customerList'
        }
      ]
    }
  }
};
</script>