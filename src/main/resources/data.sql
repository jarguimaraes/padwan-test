--Inserindo Jedi Status
insert into jedi_status values (1, 'Padawan');
insert into jedi_status values (2, 'Jedi');
insert into jedi_status values (3, 'Mestre Jedi');
commit;



-- Inserindo Jedis
insert into public.jedi (id, jedi_mentor_id, midichlorians, nome, status_id) values (0, 0, 999999, 'Eleonardo', 3);
insert into public.jedi (jedi_mentor_id, midichlorians, nome, status_id) values (0, 130000, 'Brenda', 2);
insert into public.jedi (jedi_mentor_id, midichlorians, nome, status_id) values (0, 130, 'Romário', 1);
insert into public.jedi (jedi_mentor_id, midichlorians, nome, status_id) values (0, 700000, 'Ricardo', 3);
insert into public.jedi (jedi_mentor_id, midichlorians, nome, status_id) values (0, 500000, 'Cláudia', 3);
insert into public.jedi (jedi_mentor_id, midichlorians, nome, status_id) values (3, 450000, 'Patrícia', 3);
insert into public.jedi (jedi_mentor_id, midichlorians, nome, status_id) values (3, 200000, 'Bruno', 2);
insert into public.jedi (jedi_mentor_id, midichlorians, nome, status_id) values (4, 200000, 'Breno', 2);
insert into public.jedi (jedi_mentor_id, midichlorians, nome, status_id) values (4, 150000, 'Ana', 2);
commit;