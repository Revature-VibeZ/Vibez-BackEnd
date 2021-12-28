INSERT INTO public.users
(user_id, bio, email, first_name, last_name, password, profile_picture, username)
VALUES
(1, 'bio', 'email1', 'first', 'last', 'password', 'profileimageurl', 'username1');

INSERT INTO public.users
(user_id, bio, email, first_name, last_name, password, profile_picture, username)
VALUES
(2, 'bio', 'email2', 'first', 'last', 'password', 'profileimageurl', 'username2');

INSERT INTO public.posts
(post_id, content, timestamp, image, title, user_id)
VALUES
(1, 'postcontent1', CURRENT_TIMESTAMP, 'imageurl', 'test1', 1);

INSERT INTO public.posts
(post_id, content, timestamp, image, title, user_id)
VALUES
(2, 'postcontent2', CURRENT_TIMESTAMP, 'imageurl', 'test2', 1);

INSERT INTO public.posts
(post_id, content, timestamp, image, title, user_id)
VALUES
(3, 'postcontent3', CURRENT_TIMESTAMP, 'imageurl', 'test3', 1);