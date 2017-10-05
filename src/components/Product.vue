<template>
  <span>
    <f7-card>
        <f7-card-content>
             <div class="list-block media-list">
                <ul>
                    <li class="item-content">
                    <div class="item-media">
                        <img src="http://via.placeholder.com/200x200" width="80">
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
            <div>
                Quant:  <b>{{quant}}</b>
            </div>
        </f7-card-footer>
        <f7-card-footer>
           
            <f7-button @click="increment">+</f7-button>
            <f7-button @click="decrement">-</f7-button>
            <f7-button @click="decrement">Buy now</f7-button>
        </f7-card-footer>
        
    </f7-card>
  </span>
</template>

<script>
    export default {
        data: () => {
            return {
                quant: 0
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
        }
    }
</script>