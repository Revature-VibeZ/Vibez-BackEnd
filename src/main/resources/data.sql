-- create 3 users, username1/username2/username3, all with the same password of password
    INSERT INTO public.users
    (id, bio, email, first_name, last_name, password, profile_picture, username)
    VALUES
    (1, 'bio', 'email1', 'first', 'last', 'password', 'profileimageurl', 'username1');

    INSERT INTO public.users
    (id, bio, email, first_name, last_name, password, profile_picture, username)
    VALUES
    (2, 'bio', 'email2', 'first', 'last', 'password', 'profileimageurl', 'username2');

    INSERT INTO public.users
    (id, bio, email, first_name, last_name, password, profile_picture, username)
    VALUES
    (3, 'bio', 'email3', 'lots of comments', 'person', 'password', 'profileimageurl', 'username3');


	insert into USERS (bio, email, first_name, last_name, password, profile_picture, username) 
		values ('feugiat et eros vestibulum ac est lacinia nisi venenatis tristique', 'dharriskine0@canalblog.com', 'Darrelle', 'Harriskine', 'pass', 'http://dummyimage.com/201x100.png/dddddd/000000', 'User');
	insert into USERS (bio, email, first_name, last_name, password, profile_picture, username) 
		values ('lectus pellentesque eget nunc donec quis orci eget orci vehicula condimentum curabitur', 'aertel1@newsvine.com', 'Almeria', 'Ertel', 'bIHAwpp5', 'http://dummyimage.com/120x100.png/5fa2dd/ffffff', 'aertel1');
	insert into USERS (bio, email, first_name, last_name, password, profile_picture, username) 
		values ('semper interdum mauris ullamcorper purus sit amet nulla quisque arcu libero rutrum ac lobortis vel dapibus at diam nam tristique', 'bgreathead2@google.ca', 'Blake', 'Greathead', 'ZigPFqL', 'http://dummyimage.com/231x100.png/ff4444/ffffff', 'bgreathead2');
	insert into USERS (bio, email, first_name, last_name, password, profile_picture, username) 
		values ('a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor', 'ghasluck3@soup.io', 'George', 'Hasluck', '033GcBK', 'http://dummyimage.com/193x100.png/dddddd/000000', 'ghasluck3');
	insert into USERS (bio, email, first_name, last_name, password, profile_picture, username) 
		values ('ipsum dolor sit amet consectetuer adipiscing elit proin risus praesent lectus vestibulum quam sapien varius ut', 'uregnard4@twitpic.com', 'Ulrika', 'Regnard', 'DAnDaHK3M8T', 'http://dummyimage.com/237x100.png/dddddd/000000', 'uregnard4');
	insert into USERS (bio, email, first_name, last_name, password, profile_picture, username) 
		values ('eget massa tempor convallis nulla neque libero convallis eget eleifend luctus ultricies eu nibh quisque id justo sit amet sapien', 'rmoakes5@arstechnica.com', 'Roseann', 'Moakes', 'dXlQ9WyDp', 'http://dummyimage.com/106x100.png/ff4444/ffffff', 'rmoakes5');
	insert into USERS (bio, email, first_name, last_name, password, profile_picture, username) 
		values ('est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum primis in faucibus orci luctus et', 'ipowelee6@google.com', 'Indira', 'Powelee', 'yZ7eSkXweU4', 'http://dummyimage.com/241x100.png/5fa2dd/ffffff', 'ipowelee6');
	insert into USERS (bio, email, first_name, last_name, password, profile_picture, username) 
		values ('morbi porttitor lorem id ligula suspendisse ornare consequat lectus in', 'alongstreet7@mediafire.com', 'Armando', 'Longstreet', '3cfqbs0hn', 'http://dummyimage.com/155x100.png/5fa2dd/ffffff', 'alongstreet7');
	insert into USERS (bio, email, first_name, last_name, password, profile_picture, username) 
		values ('nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel', 'mplank8@arstechnica.com', 'Matias', 'Plank', 'RmNKM6F4', 'http://dummyimage.com/181x100.png/5fa2dd/ffffff', 'mplank8');
	insert into USERS (bio, email, first_name, last_name, password, profile_picture, username) 
		values ('curae duis faucibus accumsan odio curabitur convallis duis consequat dui nec nisi volutpat', 'mbullin9@sfgate.com', 'Marcy', 'Bullin', 'pDmumlS', 'http://dummyimage.com/159x100.png/5fa2dd/ffffff', 'mbullin9');   

    
-- create 6 "posts" or 1 post with 4 comments of varying depth, and a second top level post
    -- first is a top level post! note how parent_id is null in Postgresql; in Java this value will be converted into an Integer as null, meaning it is not nested at all. top level.
    INSERT INTO public.posts
    (id, author_id, content, timestamp, image, parent_id, title)
    VALUES
    (1, 1, 'top level post! parent id is null.', CURRENT_TIMESTAMP, 'imageurl', null, 'first title');

    -- second is a "comment" which is just a nested post with parent id of 1, referencing the first post we just created.
    INSERT INTO public.posts
    (id, author_id, content, timestamp, image, parent_id, title)
    VALUES
    (2, 2, 'comment or nested post, parent id is not zero', CURRENT_TIMESTAMP, 'imageurl', 1, 'second title');

    -- third is a "reply" to the previous "comment" which is again, just a nested post but this time with a parent id of 2, referencing the "comment"
    INSERT INTO public.posts
    (id, author_id, content, timestamp, image, parent_id, title)
    VALUES
    (3, 3, 'reply or 2+ levels deep post to comment 1, parent id is not zero', CURRENT_TIMESTAMP, 'imageurl', 2, 'third title');

    -- deeper comment
    INSERT INTO public.posts
    (id, author_id, content, timestamp, image, parent_id, title)
    VALUES
    (4, 3, '3 levels deep', CURRENT_TIMESTAMP, 'imageurl', 3, 'fourth title');

    -- even deeper comment
    INSERT INTO public.posts
    (id, author_id, content, timestamp, image, parent_id, title)
    VALUES
    (5, 3, 'etc levels deep', CURRENT_TIMESTAMP, 'imageurl', 4, 'fifth title');
    
    -- second top level post!
    INSERT INTO public.posts
    (id, author_id, content, timestamp, image, parent_id, title)
    VALUES
    (6, 3, 'second top level post', CURRENT_TIMESTAMP, 'imageurl', null, 'second top level post');

-- create 2 likes. user 1 and user 3 like the top level post.
    -- yes this person is liking their own post, deal with it 😎
    INSERT INTO public.likes
    (id, post_id, user_id)
    VALUES
    (1, 1, 1);

    INSERT INTO public.likes
    (id, post_id, user_id)
    VALUES
    (2, 1, 3);

-- create 3 friendships
    INSERT INTO public.friendships
    (id, first_user_id, second_user_id)
    VALUES
    (1, 1, 2);

    INSERT INTO public.friendships
    (id, first_user_id, second_user_id)
    VALUES
    (2, 1, 3);

    INSERT INTO public.friendships
    (id, first_user_id, second_user_id)
    VALUES
    (3, 2, 3);

-- copy paste and run this in h2 console to see all tables/rows
    select * from users;
    select * from posts;
    select * from likes;
    select * from friendships;
