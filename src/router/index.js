import about from './components/pages/About.vue'
import checkout from './components/pages/Checkout.vue'
import products from './components/pages/Products.vue'

export default [
    {
      path: '/about/',
      component: about
    },
    {
      path: '/checkout/',
      component: checkout
    },
    {
      path: '/products/',
      component: products
    }
  ]
