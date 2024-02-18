BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "android_metadata" (
	"locale"	TEXT
);
CREATE TABLE IF NOT EXISTS "UserInfo" (
	"UserId"	INTEGER NOT NULL,
	"Email"	VARCHAR,
	"Password"	VARCHAR,
	"UserType"	VARCHAR,
	PRIMARY KEY("UserId" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "UserReviews" (
	"ReviewId"	INTEGER NOT NULL,
	"Name"	VARCHAR,
	"Address"	VARCHAR,
	"Review"	VARCHAR,
	PRIMARY KEY("ReviewId" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "CustomerInfo" (
	"CustomerId"	INTEGER NOT NULL,
	"Name"	VARCHAR,
	"Address"	VARCHAR,
	"Phone"	VARCHAR,
	"Pet name"	VARCHAR,
	"Pet Breed"	VARCHAR,
	"Pet age"	VARCHAR,
	"Pet sex"	VARCHAR,
	"Times"	VARCHAR,
	PRIMARY KEY("CustomerId" AUTOINCREMENT)
);
INSERT INTO "android_metadata" ("locale") VALUES ('en_US');
INSERT INTO "UserInfo" ("UserId","Email","Password","UserType") VALUES (1,'lakna@gmail.com','1234','Customer');
COMMIT;
