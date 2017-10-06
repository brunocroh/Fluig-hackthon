<template>
  <div class="paypal-button">
    <div id="paypal-button"></div>
  </div>
</template>

<script src="https://www.paypalobjects.com/api/checkout.js"></script>
<script>


export default {
  name: 'paypal-button',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  mounted: function(){
    paypal.Button.render({
      env: 'sandbox',
      style: {
          label: 'checkout',  // checkout | credit | pay | buynow | generic
          size:  'responsive', // small | medium | large | responsive
          shape: 'pill',   // pill | rect
          color: 'gold'   // gold | blue | silver | black
      },
      client: {
        sandbox: 'ATNsAVTCUJGkyoFKE-zqJjAEGmRV91NBCAk3dKUOkQ5HAUdSydNf9-VcNgFxiYH-LRBX1Wz5062ExFzV'
      },
      commit: true,
      payment: function(data, actions){
        return actions.payment.create({
          payment: {
            transactions: [
              {
                amount: {total: '1.00', currency: 'BRL'}
              }
            ]
          }
        })
      },
      onAuthorize: function(data, actions){
        return actions.payment.execute().then(function(payment){
          console.log("pagamento realizado");
        })
      }
    }, '#paypal-button')
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
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
