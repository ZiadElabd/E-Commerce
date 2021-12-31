import Vue from 'vue'
import VueRouter from 'vue-router'
import Friends from '../views/Friends.vue'
import Notifications from '../views/Notifications.vue'
import Settings from '../views/Settings.vue'
import SignIn from '../components/SignIn.vue'
import SignUp from '../components/SignUp.vue'
import ChangePassword from '../components/ChangePassword.vue'
import Products from '../components/Products.vue'
import displayProduct from '../components/displayProduct.vue'
import newProduct from '../components/newProduct.vue'



Vue.use(VueRouter)

const routes = [
  
  {
    path: '/',
    name: 'SignIn',
    component: SignIn
  },
  {
    path: '/Products/:category',
    name: 'Products',
    component: Products
  },
  {
    path: '/newProduct',
    name: 'newProduct',
    component: newProduct
  },
  {
    path: '/displayProduct',
    name: 'displayProduct',
    component: displayProduct
  },
  {
    path: '/signup',
    name: 'SignUp',
    component: SignUp
  },
  {
    path: '/ChangePassword',
    name: 'ChangePassword',
    component: ChangePassword
  },
  {
    path: '/Friends',
    name: 'Friends',
    component: Friends
  },
  {
    path: '/Notifications',
    name: 'Notifications',
    component: Notifications
  },
  

  {
    path: '/Settings',
    name: 'Settings',
    component: Settings
  },
 
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
