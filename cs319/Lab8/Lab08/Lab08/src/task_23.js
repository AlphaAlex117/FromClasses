class Header extends React.Component {
    render() {
        return (
            <header>
                <h2>CS 319</h2>
            </header>
        );
    }
}

class Nav extends React.Component {
    render() {
        return (
            <nav>
                <ul>
                    <li>Introduction</li>
                    <li>Basics</li>
                    <li>JavaScript</li>
                </ul>
            </nav>
        );
    }
}

class Article extends React.Component {
    render() {
        return (
            <article>
                <h1>Intro to React</h1>
                <p>This is an intro to React</p>
            </article>
        );
    }
}

class Acomponent extends React.Component {
    render() {
        const divStyle = {
            color: 'green',
            textAlign: 'center',
        };
        return (<div>
            <p style={divStyle}> A simple react component with inline style</p>
        </div>);
    }
}

class Footer extends React.Component {
    render() {
        return (
            <footer>
                <p>Class of 2020</p>
            </footer>
        );
    }
}

class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            menu_items : ['Introduction', 'Basics', 'Javascript']
        };
        this.handleAddItem = this.handleAddItem.bind(this);
    }
    render() {
        return(
            <div>
                <Header />
                <Nav menu_items={this.state.menu_items} handleAddItem={this.handleAddItem}/>
                <Article />
                <Footer />
            </div>
        );
    }

    handleAddItem(event) {
        event.preventDefault();
        const new_item = event.target.elements.new_item.value.trim();

        if (!new_item) {
            alert('Enter valid value to add item');
        }

        this.setState(function(prevState, props) {
            return {
                menu_items: prevState.menu_items.concat(new_item)
            };
        });
    }
}


ReactDOM.render(<App />, document.getElementById("app"));