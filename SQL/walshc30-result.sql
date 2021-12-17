
walshc30=> \i walshc30-tables.sql
psql:walshc30-tables.sql:8: ERROR:  relation "blogger" already exists
psql:walshc30-tables.sql:16: ERROR:  relation "blog" already exists
psql:walshc30-tables.sql:22: ERROR:  there is no unique constraint matching given keys for referenced table "blog"
psql:walshc30-tables.sql:29: ERROR:  relation "tag" does not exist
walshc30=> \i walshc30-data.sql
psql:walshc30-data.sql:1: ERROR:  duplicate key value violates unique constraint "blogger_pkey"
DETAIL:  Key (id)=(1234 ) already exists.
psql:walshc30-data.sql:2: ERROR:  duplicate key value violates unique constraint "blogger_pkey"
DETAIL:  Key (id)=(2345 ) already exists.
psql:walshc30-data.sql:3: ERROR:  duplicate key value violates unique constraint "blogger_pkey"
DETAIL:  Key (id)=(3456 ) already exists.
psql:walshc30-data.sql:4: ERROR:  duplicate key value violates unique constraint "blogger_pkey"
DETAIL:  Key (id)=(4567 ) already exists.
psql:walshc30-data.sql:6: ERROR:  duplicate key value violates unique constraint "blog_pkey"
DETAIL:  Key (id)=(10   ) already exists.
psql:walshc30-data.sql:7: ERROR:  duplicate key value violates unique constraint "blog_pkey"
DETAIL:  Key (id)=(11   ) already exists.
psql:walshc30-data.sql:8: ERROR:  duplicate key value violates unique constraint "blog_pkey"
DETAIL:  Key (id)=(12   ) already exists.
psql:walshc30-data.sql:9: ERROR:  duplicate key value violates unique constraint "blog_pkey"
DETAIL:  Key (id)=(13   ) already exists.
psql:walshc30-data.sql:11: ERROR:  relation "tag" does not exist
LINE 1: INSERT INTO "tag" VALUES('1','UofS');
                    ^
psql:walshc30-data.sql:12: ERROR:  relation "tag" does not exist
LINE 1: INSERT INTO "tag" VALUES('2','basketball');
                    ^
psql:walshc30-data.sql:13: ERROR:  relation "tag" does not exist
LINE 1: INSERT INTO "tag" VALUES('3','volleyball');
                    ^
psql:walshc30-data.sql:15: ERROR:  relation "post_tag" does not exist
LINE 1: INSERT INTO "post_tag" VALUES('10','1');
                    ^
psql:walshc30-data.sql:16: ERROR:  relation "post_tag" does not exist
LINE 1: INSERT INTO "post_tag" VALUES('10','2');
                    ^
psql:walshc30-data.sql:17: ERROR:  relation "post_tag" does not exist
LINE 1: INSERT INTO "post_tag" VALUES('12','2');
                    ^
walshc30=> \i walshc30-query.sql
psql:walshc30-query.sql:3: ERROR:  column "Scranton" does not exist
LINE 3: WHERE city="Scranton";
                   ^
psql:walshc30-query.sql:7: ERROR:  column blog.date does not exist
LINE 1: SELECT blogger.id, blogger.name, blog.id, blog.date, blog.su...
                                                  ^
psql:walshc30-query.sql:11: ERROR:  relation "post_tag" does not exist
LINE 2: FROM blogger, post_tag
                      ^
