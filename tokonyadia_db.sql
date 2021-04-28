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

 Date: 28/04/2021 22:45:47
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
  "updated_at" timestamp(6),
  "phone_number" varchar(15) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."m_customer" OWNER TO "postgres";

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
