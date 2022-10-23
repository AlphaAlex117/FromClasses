//Add your code under this line

const alertPlaceholder = document.getElementById('liveAlertPlaceholder')
const infoForm = document.getElementById('checkout-form')
const searchBarCart = document.querySelector('#inputCard')
const alertTrigger = document.getElementById('submit-btn')
const summaryCard = document.querySelector('.card')
const summaryList = document.querySelector('.card > ul')

console.log(summaryList)

var order = {name:"",
            email:"",
            card:"",
            address1:"",
            city:"",
            state:"",
            zip:""}

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

function isNumeric(n) {
    return !isNaN(parseFloat(n)) && isFinite(n);
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

if (zip.value.length == 0)
{
    zip.setAttribute("class","form-control is-invalid")
    val = false
}
else{
    zip.setAttribute("class", "form-control is-valid");
    order.zip = zip.value
}


if (val){
    infoForm.classList.add("collapse")

    for (const [key, value] of Object.entries(order)) {
        summaryList.innerHTML += '<li class="list-group-item"> <b>' + `${key}` + ': </b>' + `${value}` +'</li>'
    }
    summaryCard.classList.remove("collapse")
    alertPlaceholder.innerHTML = ""
        alert('<i class="bi-cart-check-fill"></i> You have made an order!', 'success')
}
return val;
}


