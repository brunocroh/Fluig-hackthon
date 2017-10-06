import about from './components/pages/About.vue'
import checkout from './components/pages/Checkout.vue'
import products from './components/pages/Products.vue'

export default [
    {
      path: '/',
      component: products
    },
    {
      path: '/about/',
      component: about
    },
    {
      path: '/checkout/',
      component: checkout
    }
  ]
