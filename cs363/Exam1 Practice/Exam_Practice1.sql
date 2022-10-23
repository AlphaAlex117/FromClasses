select distinct count(tid) as numTweets
from tweets;

select count(tid) as numTweetsWithMention
from tweets
where tid in
(select distinct tid
from mentions);

select count(distinct name) as numHashtagName
from hashtags;

select distinct state
from users
where state != ''
order by state asc
limit 3;

select count(tid)
from tweets
where posting_user in
(select user_name
from users
where state="Iowa");

select distinct u.screen_name
from users u left join tweets t on u.user_name = t.posting_user
where t.posting_user is null
limit 3;

select u.screen_name, u.state, count(t.tid) as numTweets
from users u inner join tweets t on u.user_name = t.posting_user
group by t.posting_user
having count(t.tid) >= 100
order by count(t.tid) desc
limit 3;

select distinct m1.mentioned_user_scr
from mentions m1, users u1, tweets t1
where m1.tid = t1.tid and t1.posting_user = u1.screen_name and u1.state='Iowa'
and m1.mentioned_user_scr in (
select m2.mentioned_user_scr
from mentions m2, users u2, tweets t2
where m2.tid = t2.tid and t2.posting_user = u2.screen_name and 
u2.state='Minnesota');