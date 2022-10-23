//Imports
const express = require('express');

// express app
const app = express();

// listen for requests
app.listen(3000);

// register view engine
app.set('view engine', 'ejs');
// app.set('views', 'myviews');

//Middleware
app.use(express.static('public'));
app.use(express.urlencoded({ extended: true }))

//Temporary data
var donations = [
    {id:'code-' + Math.floor(Math.random() * 100000), name: 'John Smith', email: 'john.smith@iastate.edu', charity: 'Red Cross',amount:100.00},
    {id:'code-' + Math.floor(Math.random() * 100000), name: 'John Doe', email: 'john.doe@iastate.edu', charity: 'Mary Greele',amount:75.00},
    {id:'code-' + Math.floor(Math.random() * 100000), name: 'Jane Doe', email: 'jane.doe@iastate.edu', charity: 'Red Cross',amount:200.00},
  ];

//Routing
app.get('/', (req, res) => {
  res.redirect('/donations')
});

app.get('/donations/', (req, res) => {
  res.render('./donations/list', { title: 'Donations', donations });
});

app.get('/about', (req, res) => {
  res.render('./about', { title: 'About' });
});

app.get('/donations/create', (req, res) => {
  res.render('./donations/create', { title: 'Donations' });
});

app.post('/donations', (req, res) => {
  if (req.body.hasOwnProperty('name')) {
    let donation = req.body
    donation.amount = Number(donation.amount)
    donation.id = 'code-' + Math.floor(Math.random() * 100000)
    donations.push(req.body)
  }
  else {
    let donation_id = req.body.donation_id.trim()
    var del_index = -1
    for (var i in donations) {
      if (donation_id == donations[i].id) {
        del_index = i
        break
      }
    }
    if (del_index > -1) {
      donations.splice(del_index, 1)
    }
  }
  res.redirect('/donations')
})

app.get('/donations/:did', (req, res) => {
  const did = req.params.did
  var found = false
  for (var i in donations) {
    if (did == donations[i].id) {
      donation = donations[i]
      found = true
      res.render('./donations/details', { title: "Donation", donation })
    }
  }
  if (!found) {
    res.status(404).render('404', { title: '404' })
  }
});

// 404 page
app.use((req, res) => {
  res.status(404).render('404', { title: '404' });
});

