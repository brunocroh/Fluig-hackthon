<template>
  <div>
    <f7-card>
        <f7-card-content>
             <div class="list-block media-list">
                <ul>
                    <li class="item-content">
                    <div class="item-media">
                        <img :src="product.img" width="80">
                    </div>
                    <div class="item-inner">
                        <div class="item-title-row">
                        <div class="item-title">{{product.name}}</div>
                        </div>
                        <div class="item-subtitle">{{product.subtitle}}</div>
                    </div>
                    </li>
                </ul>
            </div>
        </f7-card-content>
        <f7-card-footer>
            <div class="row no-gutter" style="width: 100%">
                <!-- Each "cell" has col-[widht in percents] class -->
                <div class="col-50">
                    Quant:  <b>{{quant || 0}}</b>
                </div>
                <div class="col-50">
                    Preço: R$ <b>{{product.price || 0}}</b>
                </div>
            </div>
        </f7-card-footer>
        <f7-card-footer>
          <f7-button @click="increment">+</f7-button>
          <f7-button @click="decrement">-</f7-button>
          <PayPal
            :amount="product.price.toString()"
            currency="BRL"
            :client="credentials"
            :dev="true"
            invoiceNumber="201701011000"
            >
          </PayPal>
        </f7-card-footer>
    </f7-card>
  </div>
</template>


<script>

  import PayPal from './vue-paypal-checkout/src/main'

  export default {
      data: () => {
          return {
              credentials: {
                sandbox: 'ATNsAVTCUJGkyoFKE-zqJjAEGmRV91NBCAk3dKUOkQ5HAUdSydNf9-VcNgFxiYH-LRBX1Wz5062ExFzV'
              },
              quant: 0,
              ammount: 0
          }
      },
      created: function() {

      },
      props: ["product"],
      methods: {
          increment: function() {
              this.quant++
              this.$emit("quantchanged", this.product, this.quant)
          },
          decrement: function() {
              this.quant--
              if (this.quant < 0) this.quant = 0
              this.$emit("quantchanged", this.product, this.quant)
          }
      },
    components: {
      PayPal
    }
  }
</script>

<style scoped>
    .inline-block {
        display: inline-block;
    }
    .float-right {
        float: right;
    }
</style>
