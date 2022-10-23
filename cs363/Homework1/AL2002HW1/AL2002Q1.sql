/*
	AUTHOR: Alexander Lafontaine
*/

/*
Answer for a
*/

select count(sched_date) as "num_events"
from events;

/*
Answer for b
*/

select vid, sched_date
from events
where location != "ISU Campus";

/*
Answer for c
*/

select e.vid, e.sched_date, e.location
from events e inner join participates pa inner join persons pe 
on e.vid = pa.vid and pa.pid = pe.pid and e.sched_date = pa.sched_date
where pname = "Pak";

/*
Answer for d
*/

select e.vid, e.sched_date, e.location
from events e inner join participates pa inner join persons pe 
on e.vid = pa.vid and pa.pid = pe.pid and e.sched_date = pa.sched_date
where pname = "Pak" or pname = "John"
order by sched_date desc;

/*
Answer for e
*/

select vid
from participates pa join persons pe on pe.pid = pa.pid
where pe.pname="John" and vid in
(select vid
from participates pa join persons pe on pe.pid = pa.pid
where pe.pname="Mary" and vid in
(select vid
from participates pa join persons pe on pe.pid = pa.pid
where pe.pname="Jane"));


/*
Answer for f
*/

select pe.pname
from participates pa right join persons pe on pe.pid = pa.pid
where pa.vid is null
order by pe.pid desc;

/*
Answer for g
*/

select pid, pname
from persons
where pid in
(select pid
from participates
group by pid
having count(*) >= 2);

/*
Answer for h
*/

select venue_id, name
from venues
where not exists
(select vid
from events
where venue_id = vid);

/*
Answer for i
*/

select venue_id, name
from venues
where venue_id not in
(select vid
from events
where venue_id = vid);
