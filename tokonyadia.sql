/*
 Navicat Premium Data Transfer

 Source Server         : mandiri-academy
 Source Server Type    : PostgreSQL
 Source Server Version : 130002
 Source Host           : localhost:5432
 Source Catalog        : tokonyadia
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 130002
 File Encoding         : 65001

 Date: 25/04/2021 23:05:23
*/


-- ----------------------------
-- Table structure for m_customer
-- ----------------------------
DROP TABLE IF EXISTS "public"."m_customer";
CREATE TABLE "public"."m_customer" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "first_name" varchar(255) COLLATE "pg_catalog"."default",
  "last_name" varchar(255) COLLATE "pg_catalog"."default",
  "birth_date" date,
  "address" varchar(255) COLLATE "pg_catalog"."default",
  "username" varchar(255) COLLATE "pg_catalog"."default",
  "password" varchar(255) COLLATE "pg_catalog"."default",
  "status" int4,
  "email" varchar(255) COLLATE "pg_catalog"."default",
  "created_at" timestamp(6),
  "updated_at" timestamp(6)
)
;
ALTER TABLE "public"."m_customer" OWNER TO "postgres";

-- ----------------------------
-- Records of m_customer
-- ----------------------------
BEGIN;
INSERT INTO "public"."m_customer" VALUES ('1', 'dirgantara', 'siahaan', '2020-09-09', 'jakarta', 'dirga', 'P@ssw0rd', 1, 'dirga@gmail.com', NULL, NULL);
INSERT INTO "public"."m_customer" VALUES ('4028e4907908264f0179082ea4380000', 'dirgantara', 'siahaan', '2020-09-09', 'jakarta', 'dirga', 'P@ssw0rd', 1, 'dirga@gmail.com', NULL, '2021-04-25 15:41:21.616');
INSERT INTO "public"."m_customer" VALUES ('4028e490790834c7017908356b800001', 'dirgantara', 'siahaan', '2020-09-09', 'jakarta', 'dirga', 'P@ssw0rd', 1, 'dirga@gmail.com', NULL, '2021-04-25 15:46:29.225');
INSERT INTO "public"."m_customer" VALUES ('4028e490790834c70179083627b30002', 'test', 'siahaan', '2020-09-09', 'jakarta', 'dirga', 'P@ssw0rd', 1, 'dirga@gmail.com', NULL, '2021-04-25 15:47:17.425');
INSERT INTO "public"."m_customer" VALUES ('4028e490790834c701790836628b0003', 'test1', 'siahaan', '2020-09-09', 'jakarta', 'dirga', 'P@ssw0rd', 1, 'dirga@gmail.com', NULL, '2021-04-25 15:47:32.488');
INSERT INTO "public"."m_customer" VALUES ('4028e490790834c701790834ff000000', 'test3', 'siahaan', '2020-09-09', 'jakarta', 'dirga', 'P@ssw0rd', 1, 'dirga@gmail.com', NULL, '2021-04-25 15:49:53.961');
INSERT INTO "public"."m_customer" VALUES ('4028e4907908383d01790838df510000', 'tete', 'siahaan', '2020-09-09', 'jakarta', 'dirga', 'P@ssw0rd', 1, 'dirga@gmail.com', '2021-04-25 15:50:15.503', '2021-04-25 22:38:34.842');
COMMIT;

-- ----------------------------
-- Table structure for m_merchant
-- ----------------------------
DROP TABLE IF EXISTS "public"."m_merchant";
CREATE TABLE "public"."m_merchant" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "merchant_name" varchar(255) COLLATE "pg_catalog"."default",
  "owner_name" varchar(255) COLLATE "pg_catalog"."default",
  "siup_number" varchar(255) COLLATE "pg_catalog"."default",
  "phone_number" varchar(15) COLLATE "pg_catalog"."default",
  "address" varchar(255) COLLATE "pg_catalog"."default",
  "created_at" timestamp(6),
  "updated_at" timestamp(6)
)
;
ALTER TABLE "public"."m_merchant" OWNER TO "postgres";

-- ----------------------------
-- Records of m_merchant
-- ----------------------------
BEGIN;
INSERT INTO "public"."m_merchant" VALUES ('4028e490790293d801790293f9a10000', 'indomaret', 'bambang', '123', '0812', 'jakarta', '2021-04-24 13:32:02.693', '2021-04-24 13:32:02.693');
INSERT INTO "public"."m_merchant" VALUES ('3', 'alfamart', 'kirana', '123', '0812', 'bandung', NULL, NULL);
INSERT INTO "public"."m_merchant" VALUES ('4028e490790870f6017908726c910000', 'huhu', 'bambang', '123', '0812', 'jakarta', '2021-04-25 16:53:07.21', '2021-04-25 16:53:07.21');
INSERT INTO "public"."m_merchant" VALUES ('4028e49079087bd10179087cf8d30000', 'new merchant', 'bambang', '123', '0812', 'jakarta', '2021-04-25 17:04:38.476', '2021-04-25 17:04:38.476');
INSERT INTO "public"."m_merchant" VALUES ('4028e490790882a701790882b74f0000', 'new merchant again ', 'bambang', '123', '0812', 'jakarta', '2021-04-25 17:10:54.906', '2021-04-25 17:10:54.906');
INSERT INTO "public"."m_merchant" VALUES ('4028e4907908848b017908853b330000', 'new merchant again gain ', 'bambang', '123', '0812', 'jakarta', '2021-04-25 17:13:39.744', '2021-04-25 17:13:39.744');
INSERT INTO "public"."m_merchant" VALUES ('4028e4907909ad87017909b4af300004', 'mall kokas', 'bambang', '123', '0812', 'jakarta', '2021-04-25 22:45:06.863', '2021-04-25 22:45:06.863');
INSERT INTO "public"."m_merchant" VALUES ('4028e4907909bc7a017909bccb3f0000', 'mall kokas', 'bambang', '123', '0812', 'jakarta', '2021-04-25 22:53:58.317', '2021-04-25 22:53:58.317');
INSERT INTO "public"."m_merchant" VALUES ('4028e4907909bc7a017909bd021b0002', 'mall kokas', 'bambang', '123', '0812', 'jakarta', '2021-04-25 22:54:12.379', '2021-04-25 22:54:12.379');
INSERT INTO "public"."m_merchant" VALUES ('4028e4907909bc7a017909be038e0005', 'mall kokas', 'bambang', '123', '0812', 'jakarta', '2021-04-25 22:55:18.286', '2021-04-25 22:55:18.286');
INSERT INTO "public"."m_merchant" VALUES ('4028e4907909bc7a017909be32a90008', 'mall kokas baruuu', 'bambang', '123', '0812', 'jakarta', '2021-04-25 22:55:30.345', '2021-04-25 23:02:15.382');
INSERT INTO "public"."m_merchant" VALUES ('4028e4907909bc7a017909c693610013', 'mall kokas', 'bambang', '123', '0812', 'jakarta', '2021-04-25 23:04:39.393', '2021-04-25 23:04:39.393');
INSERT INTO "public"."m_merchant" VALUES ('4028e4907909bc7a017909c696f30016', 'mall kokas', 'bambang', '123', '0812', 'jakarta', '2021-04-25 23:04:40.306', '2021-04-25 23:04:40.306');
COMMIT;

-- ----------------------------
-- Table structure for m_product
-- ----------------------------
DROP TABLE IF EXISTS "public"."m_product";
CREATE TABLE "public"."m_product" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "image" varchar(255) COLLATE "pg_catalog"."default",
  "merchant_id" varchar(255) COLLATE "pg_catalog"."default",
  "stock" int2,
  "price" numeric
)
;
ALTER TABLE "public"."m_product" OWNER TO "postgres";

-- ----------------------------
-- Records of m_product
-- ----------------------------
BEGIN;
INSERT INTO "public"."m_product" VALUES ('4028e4907902c1c1017902c2894e0001', 'product a', 'pakaian', NULL, NULL, 'gambar', '4028e490790293d801790293f9a10000', NULL, NULL);
INSERT INTO "public"."m_product" VALUES ('4028e490790863b401790864280b0000', 'product d', 'pakaian', '2021-04-25 16:37:32.152', '2021-04-25 16:39:24.537', 'gambar', NULL, NULL, NULL);
INSERT INTO "public"."m_product" VALUES ('4028e490790870f6017908726ca10001', 'huhu1 a', 'pakaian', NULL, NULL, 'gambar', '4028e490790870f6017908726c910000', NULL, NULL);
INSERT INTO "public"."m_product" VALUES ('4028e490790870f6017908726ca10002', 'huhu b', 'makanaan', NULL, NULL, NULL, '4028e490790870f6017908726c910000', NULL, NULL);
INSERT INTO "public"."m_product" VALUES ('4028e49079087bd10179087cf8dd0001', 'new produk 1', 'pakaian', NULL, NULL, 'gambar', '4028e49079087bd10179087cf8d30000', NULL, NULL);
INSERT INTO "public"."m_product" VALUES ('4028e49079087bd10179087cf8dd0002', 'new produk', 'makanaan', NULL, NULL, NULL, '4028e49079087bd10179087cf8d30000', NULL, NULL);
INSERT INTO "public"."m_product" VALUES ('4028e490790882a701790882b7690001', 'new produk 3', 'pakaian', '2021-04-25 17:10:54.906', '2021-04-25 17:10:54.906', 'gambar', '4028e490790882a701790882b74f0000', NULL, NULL);
INSERT INTO "public"."m_product" VALUES ('4028e490790882a701790882b76a0002', 'new produk 4', 'makanaan', '2021-04-25 17:10:54.906', '2021-04-25 17:10:54.906', NULL, '4028e490790882a701790882b74f0000', NULL, NULL);
INSERT INTO "public"."m_product" VALUES ('4028e4907909bc7a017909c1ddb6000d', 'product y', 'pakaian', '2021-04-25 22:55:30.345', '2021-04-25 22:59:30.74', 'gambar', NULL, 100, 100000);
INSERT INTO "public"."m_product" VALUES ('4028e4907909bc7a017909c1ddb7000e', 'product y', 'pakaian', '2021-04-25 22:55:30.345', '2021-04-25 22:59:30.74', 'gambar', NULL, 100, 10000);
INSERT INTO "public"."m_product" VALUES ('4028e4907909bc7a017909c2434c000f', 'product y', 'pakaian', '2021-04-25 22:55:30.345', '2021-04-25 22:59:56.746', 'gambar', NULL, 100, 100000);
INSERT INTO "public"."m_product" VALUES ('4028e4907909bc7a017909c2434c0010', 'product y', 'pakaian', '2021-04-25 22:55:30.345', '2021-04-25 22:59:56.746', 'gambar', NULL, 100, 10000);
INSERT INTO "public"."m_product" VALUES ('4028e4907909bc7a017909c27fe70011', 'product y', 'pakaian', '2021-04-25 22:55:30.345', '2021-04-25 23:02:15.382', 'gambar', '4028e4907909bc7a017909be32a90008', 100, 70000);
INSERT INTO "public"."m_product" VALUES ('4028e4907909bc7a017909c27fe70012', 'product y', 'pakaian', '2021-04-25 22:55:30.345', '2021-04-25 23:02:15.382', 'gambar', '4028e4907909bc7a017909be32a90008', 100, 7000);
INSERT INTO "public"."m_product" VALUES ('4028e4907909bc7a017909c693620014', 'product y', 'pakaian', '2021-04-25 23:04:39.393', '2021-04-25 23:04:39.393', 'gambar', '4028e4907909bc7a017909c693610013', 100, 100000);
INSERT INTO "public"."m_product" VALUES ('4028e4907909bc7a017909c693620015', 'product y', 'pakaian', '2021-04-25 23:04:39.393', '2021-04-25 23:04:39.393', 'gambar', '4028e4907909bc7a017909c693610013', 100, 10000);
INSERT INTO "public"."m_product" VALUES ('2', 'product b', 'makanaan', NULL, '2021-04-25 21:36:13.507', NULL, '4028e490790293d801790293f9a10000', 2, 2000);
INSERT INTO "public"."m_product" VALUES ('3', 'procut c', 'minuman', NULL, '2021-04-25 21:36:13.524', NULL, '3', 2, 1000);
INSERT INTO "public"."m_product" VALUES ('4028e4907909bc7a017909bccb530001', 'product y', 'pakaian', '2021-04-25 22:53:58.317', '2021-04-25 22:53:58.317', 'gambar', '4028e4907909bc7a017909bccb3f0000', NULL, NULL);
INSERT INTO "public"."m_product" VALUES ('4028e4907909bc7a017909bd021c0003', 'product y', 'pakaian', '2021-04-25 22:54:12.379', '2021-04-25 22:54:12.379', 'gambar', '4028e4907909bc7a017909bd021b0002', NULL, NULL);
INSERT INTO "public"."m_product" VALUES ('4028e4907909bc7a017909bd021c0004', 'product y', 'pakaian', '2021-04-25 22:54:12.379', '2021-04-25 22:54:12.379', 'gambar', '4028e4907909bc7a017909bd021b0002', NULL, NULL);
INSERT INTO "public"."m_product" VALUES ('4028e4907909bc7a017909be038f0006', 'product y', 'pakaian', '2021-04-25 22:55:18.286', '2021-04-25 22:55:18.286', 'gambar', '4028e4907909bc7a017909be038e0005', NULL, NULL);
INSERT INTO "public"."m_product" VALUES ('4028e4907909bc7a017909be038f0007', 'product y', 'pakaian', '2021-04-25 22:55:18.286', '2021-04-25 22:55:18.286', 'gambar', '4028e4907909bc7a017909be038e0005', NULL, NULL);
INSERT INTO "public"."m_product" VALUES ('4028e4907909bc7a017909c696f30017', 'product y', 'pakaian', '2021-04-25 23:04:40.306', '2021-04-25 23:04:40.306', 'gambar', '4028e4907909bc7a017909c696f30016', 100, 100000);
INSERT INTO "public"."m_product" VALUES ('4028e4907909bc7a017909c696f30018', 'product y', 'pakaian', '2021-04-25 23:04:40.306', '2021-04-25 23:04:40.306', 'gambar', '4028e4907909bc7a017909c696f30016', 100, 10000);
INSERT INTO "public"."m_product" VALUES ('4028e4907909bc7a017909be32aa0009', 'product y', 'pakaian', '2021-04-25 22:55:30.345', '2021-04-25 22:55:30.345', 'gambar', NULL, 100, 100000);
INSERT INTO "public"."m_product" VALUES ('4028e4907909bc7a017909be32aa000a', 'product y', 'pakaian', '2021-04-25 22:55:30.345', '2021-04-25 22:55:30.345', 'gambar', NULL, 100, 10000);
INSERT INTO "public"."m_product" VALUES ('4028e4907909bc7a017909c0df79000b', 'product y', 'pakaian', '2021-04-25 22:55:30.345', '2021-04-25 22:58:25.538', 'gambar', NULL, 100, 100000);
INSERT INTO "public"."m_product" VALUES ('4028e4907909bc7a017909c0df79000c', 'product y', 'pakaian', '2021-04-25 22:55:30.345', '2021-04-25 22:58:25.538', 'gambar', NULL, 100, 10000);
COMMIT;

-- ----------------------------
-- Table structure for t_purchase
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_purchase";
CREATE TABLE "public"."t_purchase" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "purchase_date" date,
  "customer_id" varchar(255) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."t_purchase" OWNER TO "postgres";

-- ----------------------------
-- Records of t_purchase
-- ----------------------------
BEGIN;
INSERT INTO "public"."t_purchase" VALUES ('1', '2021-04-25', '1');
INSERT INTO "public"."t_purchase" VALUES ('4028e49079092d500179092d7e9b0000', '2021-04-25', '1');
INSERT INTO "public"."t_purchase" VALUES ('4028e490790956390179095834fd0000', '2021-04-25', '1');
INSERT INTO "public"."t_purchase" VALUES ('4028e490790956390179095b6ae50003', '2021-04-25', '1');
INSERT INTO "public"."t_purchase" VALUES ('7e00808079095df0017909607ece0000', '2021-04-25', '1');
INSERT INTO "public"."t_purchase" VALUES ('4028e4907909614701790961d27e0000', '2021-04-25', '1');
INSERT INTO "public"."t_purchase" VALUES ('4028e490790966bc017909680ec80000', '2021-04-25', '1');
INSERT INTO "public"."t_purchase" VALUES ('4028e49079096e450179096e5f680000', '2021-04-25', '1');
INSERT INTO "public"."t_purchase" VALUES ('4028e4907909757e017909759cf70000', '2021-04-25', '1');
COMMIT;

-- ----------------------------
-- Table structure for t_purchase_detail
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_purchase_detail";
CREATE TABLE "public"."t_purchase_detail" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "quantity" int4,
  "product_id" varchar(255) COLLATE "pg_catalog"."default",
  "purchase_id" varchar(255) COLLATE "pg_catalog"."default",
  "sub_total" numeric
)
;
ALTER TABLE "public"."t_purchase_detail" OWNER TO "postgres";

-- ----------------------------
-- Records of t_purchase_detail
-- ----------------------------
BEGIN;
INSERT INTO "public"."t_purchase_detail" VALUES ('1', 10, '2', '1', NULL);
INSERT INTO "public"."t_purchase_detail" VALUES ('2', 20, '3', '1', NULL);
INSERT INTO "public"."t_purchase_detail" VALUES ('4028e49079092d500179092d7eb10001', 30, '2', '4028e49079092d500179092d7e9b0000', NULL);
INSERT INTO "public"."t_purchase_detail" VALUES ('4028e49079092d500179092d7eb10002', 30, '3', '4028e49079092d500179092d7e9b0000', NULL);
INSERT INTO "public"."t_purchase_detail" VALUES ('4028e490790956390179095835130001', 1, '2', '4028e490790956390179095834fd0000', NULL);
INSERT INTO "public"."t_purchase_detail" VALUES ('4028e490790956390179095835130002', 1, '3', '4028e490790956390179095834fd0000', NULL);
INSERT INTO "public"."t_purchase_detail" VALUES ('4028e490790956390179095b6ae60004', 1, '2', '4028e490790956390179095b6ae50003', NULL);
INSERT INTO "public"."t_purchase_detail" VALUES ('4028e490790956390179095b6ae60005', 1, '3', '4028e490790956390179095b6ae50003', NULL);
INSERT INTO "public"."t_purchase_detail" VALUES ('7e00808079095df0017909607f660001', 1, '2', '7e00808079095df0017909607ece0000', NULL);
INSERT INTO "public"."t_purchase_detail" VALUES ('7e00808079095df0017909607f660002', 1, '3', '7e00808079095df0017909607ece0000', NULL);
INSERT INTO "public"."t_purchase_detail" VALUES ('4028e4907909614701790961d3690001', 1, '2', '4028e4907909614701790961d27e0000', NULL);
INSERT INTO "public"."t_purchase_detail" VALUES ('4028e4907909614701790961d36a0002', 1, '3', '4028e4907909614701790961d27e0000', NULL);
INSERT INTO "public"."t_purchase_detail" VALUES ('4028e490790966bc017909680ee00001', 1, '2', '4028e490790966bc017909680ec80000', NULL);
INSERT INTO "public"."t_purchase_detail" VALUES ('4028e490790966bc017909680ee00002', 1, '3', '4028e490790966bc017909680ec80000', NULL);
INSERT INTO "public"."t_purchase_detail" VALUES ('4028e49079096e450179096e5f7f0001', 1, '2', '4028e49079096e450179096e5f680000', NULL);
INSERT INTO "public"."t_purchase_detail" VALUES ('4028e49079096e450179096e5f7f0002', 1, '3', '4028e49079096e450179096e5f680000', NULL);
INSERT INTO "public"."t_purchase_detail" VALUES ('4028e4907909757e017909759d0c0001', 1, '2', '4028e4907909757e017909759cf70000', 2000);
INSERT INTO "public"."t_purchase_detail" VALUES ('4028e4907909757e017909759d0c0002', 1, '3', '4028e4907909757e017909759cf70000', 1000);
COMMIT;

-- ----------------------------
-- Primary Key structure for table m_customer
-- ----------------------------
ALTER TABLE "public"."m_customer" ADD CONSTRAINT "m_customer_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table m_merchant
-- ----------------------------
ALTER TABLE "public"."m_merchant" ADD CONSTRAINT "m_merchant_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table m_product
-- ----------------------------
ALTER TABLE "public"."m_product" ADD CONSTRAINT "m_product_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_purchase
-- ----------------------------
ALTER TABLE "public"."t_purchase" ADD CONSTRAINT "t_purchase_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_purchase_detail
-- ----------------------------
ALTER TABLE "public"."t_purchase_detail" ADD CONSTRAINT "t_purchase_detail_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table m_product
-- ----------------------------
ALTER TABLE "public"."m_product" ADD CONSTRAINT "fk_product_merchant" FOREIGN KEY ("merchant_id") REFERENCES "public"."m_merchant" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table t_purchase
-- ----------------------------
ALTER TABLE "public"."t_purchase" ADD CONSTRAINT "fk_purchase_customer" FOREIGN KEY ("customer_id") REFERENCES "public"."m_customer" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table t_purchase_detail
-- ----------------------------
ALTER TABLE "public"."t_purchase_detail" ADD CONSTRAINT "fk_pdetail-purchase" FOREIGN KEY ("purchase_id") REFERENCES "public"."t_purchase" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."t_purchase_detail" ADD CONSTRAINT "fk_pdetail_product" FOREIGN KEY ("product_id") REFERENCES "public"."m_product" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
