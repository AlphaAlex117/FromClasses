select *
from emp e;

select *
from works w;

select e.eid, e.salary, w.did
from emp e
inner join works w ON e.eid = w.eid;

select e.eid, e.ename, e.salary, w.did
from emp e
left join Works w
ON e.eid = w.eid;

select 