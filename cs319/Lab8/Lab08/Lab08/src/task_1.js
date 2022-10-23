//const para = <p>This is a paragraph created with JSX.</p>

const student = {
    name: "Alex",
    class: "CS 319",
    year: 2020
};

const stud = (
    <div>
        <p>Student name: {student.name}</p>
        <p>Class name: {student.class}</p>
        <p>Year: {student.year}</p>
    </div>
);

ReactDOM.render(stud, document.getElementById("app"));