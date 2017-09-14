set current schema = APP;

insert into person values(
	trim(cast(cast ((next value for PERSON_ID) AS char(9)) as VARCHAR(9))),
	'Kirsty',
	'Anderson',
	'0398654658',
	'0409992190',
	'usr001@myorg.com',
	CURRENT TIMESTAMP,'usr001',
	CURRENT TIMESTAMP,'usr001');
	
insert into claim values(
	trim(cast (cast ((next value for CLAIM_ID) AS char(9)) as VARCHAR(9))),
	trim(cast (cast ((SYSCS_UTIL.SYSCS_PEEK_AT_SEQUENCE('APP','PERSON_ID')-1) AS char(9)) as VARCHAR(9))),
	50.55,
	'NEW',
	'regular GP visit',
	CURRENT TIMESTAMP,'usr001',
	CURRENT TIMESTAMP,'usr001');
	
insert into claim values(
	trim(cast (cast ((next value for CLAIM_ID) AS char(9)) as VARCHAR(9))),
	trim(cast (cast ((SYSCS_UTIL.SYSCS_PEEK_AT_SEQUENCE('APP','PERSON_ID')-1) AS char(9)) as VARCHAR(9))),
	180.55,
	'NEW',
	'regular dental visit',
	CURRENT TIMESTAMP,'usr001',
	CURRENT TIMESTAMP,'usr001'
);	

insert into claim values(
	trim(cast (cast ((next value for CLAIM_ID) AS char(9)) as VARCHAR(9))),
	trim(cast (cast ((SYSCS_UTIL.SYSCS_PEEK_AT_SEQUENCE('APP','PERSON_ID')-1) AS char(9)) as VARCHAR(9))),
	200.0,
	'NEW',
	'regular cancer screening visit',
	CURRENT TIMESTAMP,'usr001',
	CURRENT TIMESTAMP,'usr001'
);	

insert into person values(
	trim(cast (cast ((next value for PERSON_ID) AS char(9)) as VARCHAR(9))),	
	'Piia',
	'Ratilainen',
	'0297654658',
	'0419992191',
	'usr002@myorg.com',
	CURRENT TIMESTAMP,'usr001',
	CURRENT TIMESTAMP,'usr001'
);	
	
	
insert into claim values(
	trim(cast (cast ((next value for CLAIM_ID) AS char(9)) as VARCHAR(9))),
	trim(cast (cast ((SYSCS_UTIL.SYSCS_PEEK_AT_SEQUENCE('APP','PERSON_ID')-1) AS char(9)) as VARCHAR(9))),
	55.55,
	'COMPL',
	'regular GP visit',
	CURRENT TIMESTAMP,'usr001',
	CURRENT TIMESTAMP,'usr001'
);
	
insert into person values(
	trim(cast (cast ((next value for PERSON_ID) AS char(9)) as VARCHAR(9))),
	'Patricia',
	'De Witt',
	'0398654658',
	'0429982191',
	'usr003@myorg.com',
	CURRENT TIMESTAMP,'usr001',
	CURRENT TIMESTAMP,'usr001'
);	

insert into person values(
	trim(cast (cast ((next value for PERSON_ID) AS char(9)) as VARCHAR(9))),
	'Amanda',
	'Smith',
	'0396784658',
	'0422342191',
	'usr004@myorg.com',
	CURRENT TIMESTAMP,'usr001',
	CURRENT TIMESTAMP,'usr001'
);	

	
insert into person values(
	trim(cast(cast ((next value for PERSON_ID) AS char(9)) as VARCHAR(9))),
	'John',
	'Buttler',
	'0393667658',
	'0409995550',
	'usr001@myorg.com',
	CURRENT TIMESTAMP,'usr001',
	CURRENT TIMESTAMP,'usr001'
);
	
insert into claim values(
	trim(cast (cast ((next value for CLAIM_ID) AS char(9)) as VARCHAR(9))),
	trim(cast (cast ((SYSCS_UTIL.SYSCS_PEEK_AT_SEQUENCE('APP','PERSON_ID')-1) AS char(9)) as VARCHAR(9))),
	50.55,
	'NEW',
	'regular GP visit',
	CURRENT TIMESTAMP,'usr001',
	CURRENT TIMESTAMP,'usr001'
);

insert into claim values(
	trim(cast (cast ((next value for CLAIM_ID) AS char(9)) as VARCHAR(9))),
	trim(cast (cast ((SYSCS_UTIL.SYSCS_PEEK_AT_SEQUENCE('APP','PERSON_ID')-1) AS char(9)) as VARCHAR(9))),
	200.55,
	'PROC',
	'regular dental visit',
	CURRENT TIMESTAMP,'usr001',
	CURRENT TIMESTAMP,'usr001'
);	

insert into claim values(
	trim(cast (cast ((next value for CLAIM_ID) AS char(9)) as VARCHAR(9))),
	trim(cast (cast ((SYSCS_UTIL.SYSCS_PEEK_AT_SEQUENCE('APP','PERSON_ID')-1) AS char(9)) as VARCHAR(9))),
	150.00,
	'COMPL',
	'regular cancer screening visit',
	CURRENT TIMESTAMP,'usr001',
	CURRENT TIMESTAMP,'usr001'
);		

insert into claim values(
	trim(cast (cast ((next value for CLAIM_ID) AS char(9)) as VARCHAR(9))),
	trim(cast (cast ((SYSCS_UTIL.SYSCS_PEEK_AT_SEQUENCE('APP','PERSON_ID')-1) AS char(9)) as VARCHAR(9))),
	230.00,
	'COMPL',
	'radiology x-ray visit',
	CURRENT TIMESTAMP,'usr001',
	CURRENT TIMESTAMP,'usr001'
);		