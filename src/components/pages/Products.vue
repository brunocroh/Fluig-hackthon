<template>
  <f7-page>
    <f7-navbar title="About" back-link="Back" sliding></f7-navbar>
    <f7-block inner>

      <product
        v-for="product in products"
        v-bind:key="product.ean"
        :product="product"
        @quantchanged="productQuantChanged">
      </product>
    </f7-block>
  </f7-page>
</template>

<script>

import Firebase from 'firebase'
import Product from '../Product.vue'

var config = {
  apiKey: "AIzaSyBI7pmGyIRGUPr_3Y_9FKppgGbIQk8p9Xk",
  authDomain: "venda-top.firebaseapp.com",
  databaseURL: "https://venda-top.firebaseio.com",
  projectId: "venda-top",
  storageBucket: "venda-top.appspot.com",
  messagingSenderId: "962954542919"
};

let app = Firebase.initializeApp(config)
let db = app.database()
let productsRef = db.ref('products')

export default {
  firebase: {
    products: productsRef,
  },
  data: () => {
    return {
      selectedProducts: [],
      products: []
    }
  },
  methods: {
    getSelectedProducts: {

    },
    productQuantChanged: function(product, quant) {
      product.quant = quant
      console.log(product, quant)
      let exists = this.selectedProducts.find((listed) => listed.ean == product.ean)
      if (!exists) {
        this.selectedProducts.push(product)
      }
      if (quant == 0) {
        this.selectedProducts = this.selectedProducts.filter((listed) => listed.ean != product.ean)
      }

    }
  },
  components: {
    Product
  },
  computed: {
    countCart: function() {
      console.log(this.selectedProducts)
      let count = 0
      return this.selectedProducts.length
    }
  },
  watch: {

  }
}
</script>
