const express = require('express');

const app = express();

app.listen(3000);

app.set('view engine', 'ejs');

app.use(express.static('public'));
app.use(express.urlencoded({ extended: true }))


// Global Cart Variable
var globalCart = {juicer: 0,
    mug: 0,
    toaster: 0,
    pot: 0,
    kettle: 0,
    silverware: 0}

// Prices
const prices = {juicerPrice: 99.99,
    mugPrice: 19.99,
    toasterPrice: 199.99,
    potPrice: 249.99,
    kettlePrice: 119.99,
    silverPrice: 59.99
}

// Global Order
var globalOrder = {name:"",
    email:"",
    card:"",
    address1:"",
    city:"",
    state:"",
    zip:""}

    
// Routing //

// Main
app.get('/', (req, res) => {
    res.redirect('/browse')
});

// Get Browse View
app.get('/browse', (req, res) => {
    res.render('./pages/browse', { title: 'Browse', globalCart});
});

// Process Browse View
app.post('/browse', (req, res) => {  
    globalCart.juicer = Number(req.body.juicerInput)
    globalCart.mug = Number(req.body.mugInput)
    globalCart.toaster = Number(req.body.toasterInput)
    globalCart.pot = Number(req.body.potInput)
    globalCart.kettle = Number(req.body.kettleInput)
    globalCart.silverware = Number(req.body.silverInput)
    res.redirect('/cart')
})

// Get Cart View
app.get('/cart', (req, res) => {
    let checkoutPrices = {juicerCheckoutPrice: (globalCart.juicer * prices.juicerPrice).toFixed(2),
        mugCheckoutPrice: (globalCart.mug * prices.mugPrice).toFixed(2),
        toasterCheckoutPrice: (globalCart.toaster * prices.toasterPrice).toFixed(2),
        potCheckoutPrice: (globalCart.pot * prices.potPrice).toFixed(2),
        kettleCheckoutPrice: (globalCart.kettle * prices.kettlePrice).toFixed(2),
        silverCheckoutPrice: (globalCart.silverware * prices.silverPrice).toFixed(2),
        totalCheckoutPrice: (globalCart.juicer * prices.juicerPrice + globalCart.mug * prices.mugPrice + globalCart.toaster * prices.toasterPrice + globalCart.pot * prices.potPrice + globalCart.kettle * prices.kettlePrice + globalCart.silverware * prices.silverPrice).toFixed(2),
        totalTAXEDCheckoutPrice: (globalCart.juicer * prices.juicerPrice + globalCart.mug * prices.mugPrice + globalCart.toaster * prices.toasterPrice + globalCart.pot * prices.potPrice + globalCart.kettle * prices.kettlePrice + globalCart.silverware * prices.silverPrice + 11.50).toFixed(2)
    }
    res.render('./pages/cart', { title: 'Cart', globalCart, checkoutPrices});
});

// Process Cart View
app.post('/cart', (req, res) => {  
    globalOrder.name = req.body.nameInput
    globalOrder.email = req.body.emailInput
    globalOrder.card = req.body.cardInput
    globalOrder.address1 = req.body.address1Input
    globalOrder.address2 = req.body.address2Input
    globalOrder.city = req.body.cityInput
    globalOrder.state = req.body.stateInput
    globalOrder.zip = req.body.zipInput
    res.redirect('/confirmation')
})

// Get Confirmation View
app.get('/confirmation', (req, res) => {
    let checkoutPrices = {juicerCheckoutPrice: (globalCart.juicer * prices.juicerPrice).toFixed(2),
        mugCheckoutPrice: (globalCart.mug * prices.mugPrice).toFixed(2),
        toasterCheckoutPrice: (globalCart.toaster * prices.toasterPrice).toFixed(2),
        potCheckoutPrice: (globalCart.pot * prices.potPrice).toFixed(2),
        kettleCheckoutPrice: (globalCart.kettle * prices.kettlePrice).toFixed(2),
        silverCheckoutPrice: (globalCart.silverware * prices.silverPrice).toFixed(2),
        totalCheckoutPrice: (globalCart.juicer * prices.juicerPrice + globalCart.mug * prices.mugPrice + globalCart.toaster * prices.toasterPrice + globalCart.pot * prices.potPrice + globalCart.kettle * prices.kettlePrice + globalCart.silverware * prices.silverPrice).toFixed(2),
        totalTAXEDCheckoutPrice: (globalCart.juicer * prices.juicerPrice + globalCart.mug * prices.mugPrice + globalCart.toaster * prices.toasterPrice + globalCart.pot * prices.potPrice + globalCart.kettle * prices.kettlePrice + globalCart.silverware * prices.silverPrice + 11.50).toFixed(2)
    }
    res.render('./pages/confirmation', { title: 'Confirmation', globalCart, checkoutPrices, globalOrder});
});

// 404 page
app.use((req, res) => {
    res.status(404).render('404', { title: '404' });
  });



