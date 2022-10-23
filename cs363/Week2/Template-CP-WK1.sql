/* Author(s)

*/
-- indicate which database to use
use threetables;

/* a)
Show the number of employees in the emp_work_dept relation 
where the returned column name is numEmployees.
*/

select count(*) as numEmployees
from emp;

/*
b)	List department id, department name of each department that has a manager. 
Do not list the same department id more than one time.
*/


/*
c)	List names and salaries of employees who earn more than two million dollars in ascending order of their salary. 
Do not list the same employee more than one time. Note that names are not unique. 
*/

/*
d)	Print all the department information (did, dname, budget, managerid) about the Accounting department and Production department. Do not list the same department more than one time. 
Query Result: The order of the rows does not matter for this query.

*/

select did, dname, budget, managerid
from dept
where dname="Accounting" or dname="Production";

/*
e)	Print the name and salary of each employee who works in the Accounting department. 
Do not list the same employee more than one time.
*/

select e.ename, e.salary
from emp e, works w, dept d
where w.eid = e.eid and w.did = d.did and d.dname="Accounting";

select e.ename, e.salary
from emp e inner join works w on e.eid = w.eid inner join dept d on w.did = d.did
where d.dname="Accounting";

select e.ename, e.salary
from emp e join works w on e.eid = w.eid
where w.did in 
(select d.did
from dept d
where d.dname="Accounting");

select e.ename, e.salary
from emp e join works w on e.eid = w.eid
where exists 
(select d.did
from dept d
where d.dname="Accounting" and d.did = w.did);

/*
f)	Print the id of each employee who works in both the Production department 
    and the Maintenance department. 
    Do not list the same employee id more than one time.
*/

/* September 2 Lab 2 */

/* Group 1 */
select e.eid
from emp e
left join works w on e.eid=w.eid
where w.eid is null;

select eid
from emp
where eid not in
(select distinct eid
from works);

select eid
from emp e
where not exists
(select *
from works w where w.eid=e.eid);

/* Group 2 */
select e.eid, e.ename
from dept d, emp e
where d.budget =
(select max(budget)
from dept) and d.managerid=e.eid;

/* Group 3 */
select w.did, d.dname, max(salary)
from emp e, works w, dept d
where e.eid = w.eid and w.did = d.did
group by w.did;

/* Group 4 */
select w1.eid
from works w1, works w2, dept d1, dept d2
where w1.eid = w2.eid and w1.did = d1.did and d1.dname="Production" and w2.did = d2.did and d2.dname="Maintenance";

select w1.eid
from works w1 inner join dept d1
on w1.did=d1.did and d1.dname="Production"
and w1.eid in (select w2.eid
from works w2, dept d2
where w2.did = d2.did and d2.dname = "Maintenance");

select w1.eid
from works w1 inner join dept d1
on w1.did=d1.did and d1.dname="Production"
and exists (select *
from works w2, dept d2
where w2.did = d2.did and d2.dname = "Maintenance" and
w1.eid=w2.eid);

/* Group 5 */
SELECT w.eid, count(distinct w.did) as cnt
FROM works w
group by w.eid
having cnt = (select count(*) from dept);