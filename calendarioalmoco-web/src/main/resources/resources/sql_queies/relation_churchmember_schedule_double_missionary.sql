select
u.user_id
,u.name
, u.email
, f.name as family_name
, f.address
, fa.*
, sc.date 'Schedule date'
, CONCAT( (SELECT u.name
			FROM missionary m 
				inner join
					user u
				on m.user_id = u.user_id
			WHERE m.double_missionary_id = sc.double_missionary_id limit 0, 1)
		, ' and '
		, (SELECT u.name
			FROM missionary m 
				inner join
					user u
				on m.user_id = u.user_id
			WHERE m.double_missionary_id = sc.double_missionary_id limit 1, 1)
	) as 'Double Missionary'
from 
	church_member cm
inner join
	user u
	on cm.user_id = u.user_id
inner join
	family f
	on cm.family_id = f.family_id
inner join
	family_available_weekdays fa
	on fa.id_family_available_weekdays = f.id_family_available_weekdays
inner join
	schedule sc
	on sc.family_id = f.family_id
;