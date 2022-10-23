// ----------- //
// Browse View //
// ----------- //

// Global Cart Variable
var cart = {juicer: 0,
            mug: 0,
            toaster: 0,
            pot: 0,
            kettle: 0,
            silverware: 0}

// Prices
const juicerPrice = 99.99
const mugPrice = 19.99
const toasterPrice = 199.99
const potPrice = 249.99
const kettlePrice = 119.99
const silverPrice = 59.99

// Specific Parts of the HTML file            
const checkoutForm = document.getElementById('checkout-form')
const returnForm = document.getElementById('return-form')
const searchBarBrowse = document.getElementById('search-bar')
const searchClearButton = document.getElementById('clear-button')
const page2 = document.getElementById('page2')
const page1 = document.getElementById('page1')

// Card Inputs
const juicerInput = document.getElementById('juicer-input')
const mugInput = document.getElementById('mug-input')
const toasterInput = document.getElementById('toaster-input')
const potInput = document.getElementById('pot-input')
const kettleInput = document.getElementById('kettle-input')
const silverInput = document.getElementById('silver-input')

// Plus Buttons
const juicerPlus = document.getElementById('juicer-+')
const mugPlus = document.getElementById('mug-+')
const toasterPlus = document.getElementById('toaster-+')
const potPlus = document.getElementById('pot-+')
const kettlePlus = document.getElementById('kettle-+')
const silverPlus = document.getElementById('silver-+')

// Minus Buttons
const juicerMinus = document.getElementById('juicer--')
const mugMinus = document.getElementById('mug--')
const toasterMinus = document.getElementById('toaster--')
const potMinus = document.getElementById('pot--')
const kettleMinus = document.getElementById('kettle--')
const silverMinus = document.getElementById('silver--')

// Cards
const juicerCard = document.getElementById('juicer-card')
const mugCard = document.getElementById('mug-card')
const toasterCard = document.getElementById('toaster-card')
const potCard = document.getElementById('pot-card')
const kettleCard = document.getElementById('kettle-card')
const silverCard = document.getElementById('silver-card')

// Function to check if something is numeric.
function isNumeric(n) {
    return !isNaN(parseFloat(n)) && isFinite(n);
}

function updateAmount(cardInput, type) {
    if (!cardInput.value)
    {
        cardInput.value = 0
    }

    if (type === "plus")
    {
        cardInput.value = parseInt(cardInput.value) + 1
    }
    else if (type === "minus")
    {
        cardInput.value = parseInt(cardInput.value) - 1
    }
}

function clearSearchBar() {
    searchBarBrowse.value = null
    juicerCard.classList.remove('collapse')
    mugCard.classList.remove('collapse')
    toasterCard.classList.remove('collapse')
    potCard.classList.remove('collapse')
    kettleCard.classList.remove('collapse')
    silverCard.classList.remove('collapse')
}

// Search Bar Listener
searchBarBrowse.addEventListener('input', event => {

    

    if (!searchBarBrowse.value) {
        juicerCard.classList.remove('collapse')
        mugCard.classList.remove('collapse')
        toasterCard.classList.remove('collapse')
        potCard.classList.remove('collapse')
        kettleCard.classList.remove('collapse')
        silverCard.classList.remove('collapse')
    }
    else {
        if (searchBarBrowse.value.toLowerCase() != "juicer".substring(0, searchBarBrowse.value.length)) {
            juicerCard.classList.add('collapse')
        }
        else {
            juicerCard.classList.remove('collapse')
        }

        if (searchBarBrowse.value.toLowerCase() != "mug".substring(0, searchBarBrowse.value.length)) {
            mugCard.classList.add('collapse')
        }
        else {
            mugCard.classList.remove('collapse')
        }

        if (searchBarBrowse.value.toLowerCase() != "toaster".substring(0, searchBarBrowse.value.length)) {
            toasterCard.classList.add('collapse')
        }
        else {  
            toasterCard.classList.remove('collapse')
        }

        if (searchBarBrowse.value.toLowerCase() != "pot".substring(0, searchBarBrowse.value.length)) {
            potCard.classList.add('collapse')
        }
        else {  
            potCard.classList.remove('collapse')
        }

        if (searchBarBrowse.value.toLowerCase() != "kettle".substring(0, searchBarBrowse.value.length)) {
            kettleCard.classList.add('collapse')
        }
        else {  
            kettleCard.classList.remove('collapse')
        }

        if (searchBarBrowse.value.toLowerCase() != "silverware".substring(0, searchBarBrowse.value.length)) {
            silverCard.classList.add('collapse')
        }
        else {  
            silverCard.classList.remove('collapse')
        }
    }
})

// Search Bar Clear Button Listener
searchClearButton.addEventListener('click', event => {
    clearSearchBar()
})

// Card Inputs Listeners
juicerInput.addEventListener('input', event => {
    if (juicerInput.value >= 0 && isNumeric(juicerInput.value))
    {
        cart.juicer = parseInt(juicerInput.value)
    }
    else (
        cart.juicer = 0
    )
})
mugInput.addEventListener('input', event => {
    if (mugInput.value >= 0 && isNumeric(mugInput.value))
    {
        cart.mug = parseInt(mugInput.value)
    }
    else (
        cart.mug = 0
    )
})
toasterInput.addEventListener('input', event => {
    if (toasterInput.value >= 0 && isNumeric(toasterInput.value))
    {
        cart.toaster = parseInt(toasterInput.value)
    }
    else (
        cart.toaster = 0
    )
})
potInput.addEventListener('input', event => {
    if (potInput.value >= 0 && isNumeric(potInput.value))
    {
        cart.pot = parseInt(potInput.value)
    }
    else (
        cart.pot = 0
    )
})
kettleInput.addEventListener('input', event => {
    if (kettleInput.value >= 0 && isNumeric(kettleInput.value))
    {
        cart.kettle = parseInt(kettleInput.value)
    }
    else (
        cart.kettle = 0
    )
})
silverInput.addEventListener('input', event => {
    if (silverInput.value >= 0 && isNumeric(silverInput.value))
    {
        cart.silverware = parseInt(silverInput.value)
    }
    else (
        cart.silverware = 0
    )
})

// Plus Buttons Listeners
juicerPlus.addEventListener('click', event => {
    cart.juicer += 1;
    updateAmount(juicerInput, "plus")
})
mugPlus.addEventListener('click', event => {
    cart.mug += 1;
    updateAmount(mugInput, "plus")
})
toasterPlus.addEventListener('click', event => {
    cart.toaster += 1;
    updateAmount(toasterInput, "plus")
})
potPlus.addEventListener('click', event => {
    cart.pot += 1;
    updateAmount(potInput, "plus")
})
kettlePlus.addEventListener('click', event => {
    cart.kettle += 1;
    updateAmount(kettleInput, "plus")
})
silverPlus.addEventListener('click', event => {
    cart.silverware += 1;
    updateAmount(silverInput, "plus")
})

// Minus Buttons Listeners
juicerMinus.addEventListener('click', event => {
    if (cart.juicer > 0) 
    {
        cart.juicer -= 1;
        updateAmount(juicerInput, "minus")
    }
})
mugMinus.addEventListener('click', event => {
    if (cart.mug > 0) 
    {
        cart.mug -= 1;
        updateAmount(mugInput, "minus")
    }
})
toasterMinus.addEventListener('click', event => {
    if (cart.toaster > 0) 
    {
        cart.toaster -= 1;
        updateAmount(toasterInput, "minus")
    }
})
potMinus.addEventListener('click', event => {
    if (cart.pot > 0) 
    {
        cart.pot -= 1;
        updateAmount(potInput, "minus")
    }
})
kettleMinus.addEventListener('click', event => {
    if (cart.kettle > 0) 
    {
        cart.kettle -= 1;
        updateAmount(kettleInput, "minus")
    }
})
silverMinus.addEventListener('click', event => {
    if (cart.silverware > 0) 
    {
        cart.silverware -= 1;
        updateAmount(silverInput, "minus")
    }
})

// Checkout Form Listener
checkoutForm.addEventListener('submit', event => {

    // Clear the Search Bar
    clearSearchBar()

    // Table rows
    let juicerRow = document.getElementById('juicer-row')
    let mugRow = document.getElementById('mug-row')
    let toasterRow = document.getElementById('toaster-row')
    let potRow = document.getElementById('pot-row')
    let kettleRow = document.getElementById('kettle-row')
    let silverRow = document.getElementById('silver-row')

    page1.classList.add('collapse')
    page2.classList.remove('collapse')

    if (parseInt(cart.juicer) > 0)
    {
        juicerRow.classList.remove('collapse')
    }
    else
    {
        juicerRow.classList.add('collapse')
    }
    if (parseInt(cart.mug) > 0)
    {
        mugRow.classList.remove('collapse')
    }
    else
    {
        mugRow.classList.add('collapse')
    }
    if (parseInt(cart.toaster) > 0)
    {
        toasterRow.classList.remove('collapse')
    }
    else
    {
        toasterRow.classList.add('collapse')
    }
    if (parseInt(cart.pot) > 0)
    {
        potRow.classList.remove('collapse')
    }
    else
    {
        potRow.classList.add('collapse')
    }
    if (parseInt(cart.kettle) > 0)
    {
        kettleRow.classList.remove('collapse')
    }
    else
    {
        kettleRow.classList.add('collapse')
    }
    if (parseInt(cart.silverware) > 0)
    {
        silverRow.classList.remove('collapse')
    }
    else
    {
        silverRow.classList.add('collapse')
    }

    updateTable()

    event.preventDefault()
    event.stopPropagation()
}, false)

// Return Form Listener
returnForm.addEventListener('submit', event => {

    page2.classList.add('collapse')
    page1.classList.remove('collapse')

    event.preventDefault()
    event.stopPropagation()
}, false)



// --------- //
// Cart View //
// --------- //

// Specific Parts of the HTML file
const page3 = document.getElementById('page3')

// Table Parts
function updateTable() {
    // Amount text
    let juicerAmountText = document.getElementById('juicer-amount')
    let mugAmountText = document.getElementById('mug-amount')
    let toasterAmountText = document.getElementById('toaster-amount')
    let potAmountText = document.getElementById('pot-amount')
    let kettleAmountText = document.getElementById('kettle-amount')
    let silverAmountText = document.getElementById('silver-amount')

    // Price text
    let juicerPriceText = document.getElementById('juicer-price')
    let mugPriceText = document.getElementById('mug-price')
    let toasterPriceText = document.getElementById('toaster-price')
    let potPriceText = document.getElementById('pot-price')
    let kettlePriceText = document.getElementById('kettle-price')
    let silverPriceText = document.getElementById('silver-price')

    
    // Price Calculations
    juicerAmountText.innerHTML = `${cart.juicer}`
    juicerPriceText.innerHTML = `$${(cart.juicer * juicerPrice).toFixed(2)}`

    mugAmountText.innerHTML = `${cart.mug}`
    mugPriceText.innerHTML = `$${(cart.mug * mugPrice).toFixed(2)}`

    toasterAmountText.innerHTML = `${cart.toaster}`
    toasterPriceText.innerHTML = `$${(cart.toaster * toasterPrice).toFixed(2)}`

    potAmountText.innerHTML = `${cart.pot}`
    potPriceText.innerHTML = `$${(cart.pot * potPrice).toFixed(2)}`

    kettleAmountText.innerHTML = `${cart.kettle}`
    kettlePriceText.innerHTML = `$${(cart.kettle * kettlePrice).toFixed(2)}`

    silverAmountText.innerHTML = `${cart.silverware}`
    silverPriceText.innerHTML = `$${(cart.silverware * silverPrice).toFixed(2)}`

    // Total
    let totalPrice = (cart.juicer * juicerPrice + cart.mug * mugPrice + cart.toaster * toasterPrice + cart.pot * potPrice + cart.kettle * kettlePrice + cart.silverware * silverPrice).toFixed(2)
    let totalPriceText = document.getElementById('total-price')
    if (totalPrice != 0)
    {
        totalPriceText.innerHTML = `$${totalPrice} + $11.50 TAX = $${(parseFloat(totalPrice) + 11.50).toFixed(2)}`
    }
    else
    {
        totalPriceText.innerHTML = `$0.00`
    }
    

}

// Lab 4 and Form Parts
const alertPlaceholder = document.getElementById('liveAlertPlaceholder')
const searchBarCart = document.getElementById('inputCard')
const alertTrigger = document.getElementById('submit-btn')
const infoForm = document.getElementById('info-form')
const summaryList = document.querySelector('.card > ul')

var order = {name:"",
            email:"",
            card:"",
            address1:"",
            city:"",
            state:"",
            zip:""
            }

const alert = (message, type) => {
    const wrapper = document.createElement('div')
    wrapper.innerHTML = [
        `<div class="alert alert-${type} alert dismissible" role="alert">`,
            `<div> ${message} </div>`,
            '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
        '</div>'
    ].join('')

    alertPlaceholder.append(wrapper);
}

searchBarCart.addEventListener('input', event => {
    if (!searchBarCart.value) {
        return event.preventDefault()
    }
    else {
        searchBarCart.value = searchBarCart.value.replace(/-/g, "")
        let newVal = ""
        for (var i = 0, nums = 0; i < searchBarCart.value.length; i++) {
            if (nums != 0 && nums % 4 == 0) {
                newVal += "-"
            }

            newVal += searchBarCart.value[i]
            if (isNumeric(searchBarCart.value[i])) {
                nums++
            }
        }
        searchBarCart.value = newVal
    }
})

infoForm.addEventListener('submit', event => {
    if (!validate()) {
        alertPlaceholder.innerHTML = ""
            alert('<i class="bi-exclamation-circle"></i> Something went wrong!', 'danger')
    }
    event.preventDefault()
    event.stopPropagation()
}, false)


let validate = function(){
val = true;
let email = document.getElementById('inputEmail4')
let name = document.getElementById('inputName')
let card = document.getElementById('inputCard')

let address1 = document.getElementById('inputAddress')
let city = document.getElementById('inputCity')
let state = document.getElementById('inputState')
let zip = document.getElementById('inputZip')
  
if (!email.value.match(
    /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
    )){
    email.setAttribute("class", "form-control is-invalid");
    val = false;
}
else{
    email.setAttribute("class", "form-control is-valid");
    order.email = email.value
}

if (name.value.length == 0)
{
    name.setAttribute("class","form-control is-invalid")
    val = false
}
else{
    name.setAttribute("class", "form-control is-valid");
    order.name = name.value
}

if (!card.value.match(/^[0-9]{4}\-[0-9]{4}\-[0-9]{4}\-[0-9]{4}$/))
{
    card.setAttribute("class","form-control is-invalid")
    val = false
}
else{
    card.setAttribute("class", "form-control is-valid");
    order.card = card.value
}

if (address1.value.length == 0)
{
    address1.setAttribute("class","form-control is-invalid")
    val = false
}
else{
    address1.setAttribute("class", "form-control is-valid");
    order.address1 = address1.value
}

if (city.value.length == 0)
{
    city.setAttribute("class","form-control is-invalid")
    val = false
}
else{
    city.setAttribute("class", "form-control is-valid");
    order.city = city.value
}

if (state.value == null)
{
    state.setAttribute("class","form-control is-valid")
    val = false
}
else{
    state.setAttribute("class", "form-control is-invalid");
    order.state = state.value
}

if (zip.value.length == 0 || zip.value.length > 5)
{
    zip.setAttribute("class","form-control is-invalid")
    val = false
}
else{
    zip.setAttribute("class", "form-control is-valid");
    order.zip = zip.value
}


if (val){
    let stuffBought = document.getElementById('stuff-bought')

    page2.classList.add("collapse")

    for (const [key, value] of Object.entries(order)) {
        summaryList.innerHTML += '<li class="list-group-item"> <b>' + `${key}` + ': </b>' + `${value}` +'</li>'
    }

    // List of Objects
    if (parseInt(cart.juicer) > 0)
    {
        createProductCard(stuffBought, "Juicer", cart.juicer, juicerPrice)
    }
    if (parseInt(cart.mug) > 0)
    {
        createProductCard(stuffBought, "Mug", cart.mug, mugPrice)
    }
    if (parseInt(cart.toaster) > 0)
    {
        createProductCard(stuffBought, "Toaster", cart.toaster, toasterPrice)
    }
    if (parseInt(cart.pot) > 0)
    {
        createProductCard(stuffBought, "Pot", cart.pot, potPrice)
    }
    if (parseInt(cart.kettle) > 0)
    {
        createProductCard(stuffBought, "Kettle", cart.kettle, kettlePrice)
    }
    if (parseInt(cart.silverware) > 0)
    {
        createProductCard(stuffBought, "Cutlery", cart.silverware, silverPrice)
    }

    // Total
    const totalWrapper = document.createElement('div')
    totalWrapper.innerHTML = [
            '<div class="card">',
                '<div class="card-body">',
                    '<h5 class="card-title">',
                        `Total: $${(cart.juicer * juicerPrice + cart.mug * mugPrice + cart.toaster * toasterPrice + cart.pot * potPrice + cart.kettle * kettlePrice + cart.silverware * silverPrice + 11.50).toFixed(2)}`,
                    '</h5>',
                '</div>',
            '</div>'
        ].join('')

    stuffBought.append(totalWrapper);


    page3.classList.remove("collapse")
    alertPlaceholder.innerHTML = ""
        alert('<i class="bi-cart-check-fill"></i> You have made an order!', 'success')
}
return val;
}

// ----------------- //
// Confirmation View //
// ----------------- //

function createProductCard(division, name, amount, price) {
    const confirmationWrapper = document.createElement('div')
    confirmationWrapper.innerHTML = [
            '<div class="card">',
                `<img src="${name}.png" class="img-thumbnail" alt="...">`,
                '<div class="card-body">',
                    '<h5 class="card-title">',
                        `Amount: ${amount} | Price: $${(amount * price).toFixed(2)}`,
                    '</h5>',
                '</div>',
            '</div>'
        ].join('')

    division.append(confirmationWrapper);
}