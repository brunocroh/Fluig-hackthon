<template>
  <!-- App -->
  <div id="app">

    <!-- Statusbar -->
    <f7-statusbar></f7-statusbar>

    <!-- Left Panel -->
    <f7-panel left reveal layout="dark">
      <f7-view id="left-panel-view" navbar-through :dynamic-navbar="true">
        <f7-navbar title="Left Panel"></f7-navbar>
        <f7-pages>
          <f7-page>
            <f7-block inner>
              <p>Left panel content goes here</p>
            </f7-block>
            <f7-block-title>Load page in panel</f7-block-title>
            <f7-list>
              <f7-list-item link="/about/" title="About"></f7-list-item>
              <f7-list-item link="/form/" title="Form"></f7-list-item>
            </f7-list>
            <f7-block-title>Load page in main view</f7-block-title>
            <f7-list>
              <f7-list-item link="/about/" title="About" link-view="#main-view" link-close-panel></f7-list-item>
              <f7-list-item link="/form/" title="Form" link-view="#main-view" link-close-panel></f7-list-item>
              <f7-list-item link="/products/" title="Products" link-view="#main-view" link-close-panel></f7-list-item>
            </f7-list>
          </f7-page>
        </f7-pages>
      </f7-view>
    </f7-panel>

    <!-- Right Panel -->
    <f7-panel right cover layout="dark">
      <f7-view id="right-panel-view" navbar-through :dynamic-navbar="true">
        <f7-navbar title="Right Panel" sliding></f7-navbar>
        <f7-pages>
          <f7-page>
            <f7-block>
              <p>Right panel content goes here</p>
            </f7-block>
            <f7-block-title>Load page in panel</f7-block-title>
            <f7-list>
              <f7-list-item link="/about/" title="About"></f7-list-item>
              <f7-list-item link="/form/" title="Form"></f7-list-item>
            </f7-list>
            <f7-block-title>Load page in main view</f7-block-title>
            <f7-list>
              <f7-list-item link="/about/" title="About" link-view="#main-view" link-close-panel></f7-list-item>
              <f7-list-item link="/form/" title="Form" link-view="#main-view" link-close-panel></f7-list-item>
            </f7-list>
          </f7-page>
        </f7-pages>
      </f7-view>
    </f7-panel>

    <!-- Main Views -->
    <f7-views>
      <f7-view id="main-view" navbar-through :dynamic-navbar="true" main>
        <!-- Navbar -->
        <f7-navbar>
          <f7-nav-left>
            <f7-link icon="icon-bars" open-panel="left"></f7-link>
          </f7-nav-left>
          <f7-nav-center sliding>Venda TOP</f7-nav-center>
          <f7-nav-right>
            <f7-link icon="icon-box_fill" href="/checkout">({{countCart}})</f7-link>
          </f7-nav-right>
        </f7-navbar>
        <!-- Pages -->
        <f7-pages>
          <f7-page>
            <ProductsPage></ProductsPage>
            <f7-list link="/products/" title="Products"></f7-list>
            <f7-list link="/about/" title="About"></f7-list>
          </f7-page>
        </f7-pages>
      </f7-view>
    </f7-views>

  </div>
</template>

<script>
import product from './components/Product'
import productList from './static/products'
import ProductsPage from './components/pages/Products.vue'

export default {

  data: () => {
    return {
      selectedProducts: [],
      products: productList
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
    product,
    ProductsPage
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
