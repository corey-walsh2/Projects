SELECT id,name
FROM blogger
WHERE city="Scranton";

SELECT blogger.id, blogger.name, blog.id, blog.date, blog.subject
FROM blogger, blog
WHERE blogger_id=blogger.id;

SELECT blogger.id, blogger.name
FROM blogger, post_tag
WHERE blogger.id=post_id AND post_id=NULL;
