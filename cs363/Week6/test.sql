create procedure GetSailorRating(
in sailor_sid integer, inout rating integer)
select s.rating into rating
from Sailors s
where sid = sailor-sid;

set @rating=7;
