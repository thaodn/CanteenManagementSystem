/* CONSTRUCT */
--	CREATE DATABASE
--	CREATE TABLE
-- 	CREATE CONSTRAINT
--	CREATE PROCEDURE


USE master
GO
IF EXISTS(SELECT name FROM sys.databases WHERE name='Canteen')
DROP DATABASE Canteen
GO
CREATE DATABASE Canteen
GO
/* End create database */
USE [Canteen]
GO
/****** Object:  Table [dbo].[BillDetail]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BillDetail](
	[BillId] [int] NOT NULL,
	[ItemId] [int] NOT NULL,
	[Quantity] [int] NULL,
	[Rate] [float] NULL,
 CONSTRAINT [PK_BillDetail] PRIMARY KEY CLUSTERED 
(
	[BillId] ASC,
	[ItemId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BillMaster]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BillMaster](
	[BillId] [int] IDENTITY(1,1) NOT NULL,
	[CreateDate] [datetime] NULL,
	[CoupenNo] [nvarchar](50) NOT NULL,
	[CoupenDate] [datetime] NULL,
	[Comment] [nvarchar](50) NULL,
	[EmployeeId] [int] NOT NULL,
	[Status] [tinyint] NOT NULL,
 CONSTRAINT [PK_BillMaster] PRIMARY KEY CLUSTERED 
(
	[BillId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DepartmentMaster]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DepartmentMaster](
	[DepartmentId] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](100) NULL,
	[Status] [tinyint] NULL,
 CONSTRAINT [PK_DepartmentMaster] PRIMARY KEY CLUSTERED 
(
	[DepartmentId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[EmployeeMaster]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EmployeeMaster](
	[EmployeeId] [int] IDENTITY(1,1) NOT NULL,
	[DepartmentId] [int] NOT NULL,
	[Username] [nvarchar](30) NOT NULL,
	[Password] [nvarchar](40) NOT NULL,
	[FullName] [nvarchar](50) NULL,
	[Address] [nvarchar](100) NULL,
	[Phone] [nvarchar](15) NULL,
	[Email] [nvarchar](100) NULL,
	[Status] [tinyint] NOT NULL,
	[Role] [tinyint] NOT NULL,
 CONSTRAINT [PK_EmployeeMaster] PRIMARY KEY CLUSTERED 
(
	[EmployeeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[FeedBack]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FeedBack](
	[FeedBackId] [int] IDENTITY(1,1) NOT NULL,
	[EmployeeId] [int] NOT NULL,
	[Title] [nvarchar](200) NOT NULL,
	[Date] [datetime] NULL,
	[Message] [nvarchar](max) NULL,
	[Status] [tinyint] NOT NULL,
 CONSTRAINT [PK_FeedBack] PRIMARY KEY CLUSTERED 
(
	[FeedBackId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ItemMaster]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ItemMaster](
	[ItemId] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](100) NULL,
	[Image] [nvarchar](50) NULL,
	[ItemTypeId] [int] NULL,
	[Rate] [float] NULL,
	[Quantity] [int] NULL,
	[Special] [tinyint] NULL,
	[Status] [tinyint] NULL,
 CONSTRAINT [PK_ItemMaster] PRIMARY KEY CLUSTERED 
(
	[ItemId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ItemTypeMaster]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ItemTypeMaster](
	[ItemTypeId] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](100) NULL,
	[Status] [tinyint] NULL,
 CONSTRAINT [PK_ItemTypeMaster] PRIMARY KEY CLUSTERED 
(
	[ItemTypeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[BillDetail]  WITH CHECK ADD  CONSTRAINT [FK_BillDetail_BillMaster] FOREIGN KEY([BillId])
REFERENCES [dbo].[BillMaster] ([BillId])
GO
ALTER TABLE [dbo].[BillDetail] CHECK CONSTRAINT [FK_BillDetail_BillMaster]
GO
ALTER TABLE [dbo].[BillDetail]  WITH CHECK ADD  CONSTRAINT [FK_BillDetail_ItemMaster] FOREIGN KEY([ItemId])
REFERENCES [dbo].[ItemMaster] ([ItemId])
GO
ALTER TABLE [dbo].[BillDetail] CHECK CONSTRAINT [FK_BillDetail_ItemMaster]
GO
ALTER TABLE [dbo].[BillMaster]  WITH CHECK ADD  CONSTRAINT [FK_BillMaster_EmployeeMaster] FOREIGN KEY([EmployeeId])
REFERENCES [dbo].[EmployeeMaster] ([EmployeeId])
GO
ALTER TABLE [dbo].[BillMaster] CHECK CONSTRAINT [FK_BillMaster_EmployeeMaster]
GO
ALTER TABLE [dbo].[EmployeeMaster]  WITH CHECK ADD  CONSTRAINT [FK_EmployeeMaster_DepartmentMaster] FOREIGN KEY([DepartmentId])
REFERENCES [dbo].[DepartmentMaster] ([DepartmentId])
GO
ALTER TABLE [dbo].[EmployeeMaster] CHECK CONSTRAINT [FK_EmployeeMaster_DepartmentMaster]
GO
ALTER TABLE [dbo].[FeedBack]  WITH CHECK ADD  CONSTRAINT [FK_FeedBack_EmployeeMaster] FOREIGN KEY([EmployeeId])
REFERENCES [dbo].[EmployeeMaster] ([EmployeeId])
GO
ALTER TABLE [dbo].[FeedBack] CHECK CONSTRAINT [FK_FeedBack_EmployeeMaster]
GO
ALTER TABLE [dbo].[ItemMaster]  WITH CHECK ADD  CONSTRAINT [FK_ItemMaster_ItemTypeMaster] FOREIGN KEY([ItemTypeId])
REFERENCES [dbo].[ItemTypeMaster] ([ItemTypeId])
GO
ALTER TABLE [dbo].[ItemMaster] CHECK CONSTRAINT [FK_ItemMaster_ItemTypeMaster]
GO
/****** Object:  StoredProcedure [dbo].[sp_Bill_GetByAll]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_Bill_GetByAll]
AS
BEGIN
SELECT [BillId]
      ,[CreateDate]
      ,[CoupenNo]
      ,[CoupenDate]
      ,[Comment]
      ,[EmployeeId]
      ,[Status]
  FROM [dbo].[BillMaster]
END


GO
/****** Object:  StoredProcedure [dbo].[sp_Bill_GetByEmpId]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_Bill_GetByEmpId]
@EmployeeId tinyint
AS
BEGIN
SELECT [BillId]
      ,[CreateDate]
      ,[CoupenNo]
      ,[CoupenDate]
      ,[Comment]
      ,[EmployeeId]
      ,[Status]
  FROM [dbo].[BillMaster]
  WHERE [EmployeeId] = @EmployeeId
END


GO
/****** Object:  StoredProcedure [dbo].[sp_Bill_GetById]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_Bill_GetById]
@BillId int
AS
BEGIN
SELECT [BillId]
      ,[CreateDate]
      ,[CoupenNo]
      ,[CoupenDate]
      ,[Comment]
      ,[EmployeeId]
      ,[Status]
  FROM [dbo].[BillMaster]
  WHERE [BillId] = @BillId
END


GO
/****** Object:  StoredProcedure [dbo].[sp_Bill_GetByStatus]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_Bill_GetByStatus]
@EmployeeId int,
@Status tinyint
AS
BEGIN
IF @EmployeeId = 0
	BEGIN
	SELECT [BillId]
		  ,[CreateDate]
		  ,[CoupenNo]
		  ,[CoupenDate]
		  ,[Comment]
		  ,[EmployeeId]
		  ,[Status]
	  FROM [dbo].[BillMaster]
	  WHERE [Status] = @Status
	END
ELSE
	BEGIN
	SELECT [BillId]
		  ,[CreateDate]
		  ,[CoupenNo]
		  ,[CoupenDate]
		  ,[Comment]
		  ,[EmployeeId]
		  ,[Status]
	  FROM [dbo].[BillMaster]
	  WHERE [EmployeeId] = @EmployeeId AND [Status] = @Status
	END
END
GO
/****** Object:  StoredProcedure [dbo].[sp_Bill_Insert]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_Bill_Insert]
	@CreateDate datetime,
	@CoupenNo nvarchar(50),
	@CoupenDate datetime,
	@Comment nvarchar(50),
	@EmployeeId int,
	@Status tinyint
AS
BEGIN
	INSERT INTO [dbo].[BillMaster]
           ([CreateDate]
           ,[CoupenNo]
           ,[CoupenDate]
           ,[Comment]
           ,[EmployeeId]
           ,[Status])
     VALUES
			(@CreateDate,
			@CoupenNo,
			@CoupenDate,
			@Comment,
			@EmployeeId,
			@Status)
END


GO
/****** Object:  StoredProcedure [dbo].[sp_Bill_Update]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_Bill_Update]
	@BillId int,
	@CreateDate datetime,
	@CoupenNo nvarchar(50),
	@CoupenDate datetime,
	@Comment nvarchar(50),
	@EmployeeId int,
	@Status tinyint
AS
BEGIN
	UPDATE [BillMaster] SET
           [CreateDate]=@CreateDate
           ,[CoupenNo]=@CoupenNo
           ,[CoupenDate]=@CoupenDate
           ,[Comment]=@Comment
           ,[EmployeeId]=@EmployeeId
           ,[Status]=@Status			
	WHERE [BillId]=@BillId
END


GO
/****** Object:  StoredProcedure [dbo].[sp_Bill_UpdateComment]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_Bill_UpdateComment]
	@BillId int,
	@Comment nvarchar(50)
AS
BEGIN
	UPDATE [BillMaster] SET
          
           [Comment]=@Comment
           	
	WHERE [BillId]=@BillId
END


GO
/****** Object:  StoredProcedure [dbo].[sp_Bill_UpdateStatus]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_Bill_UpdateStatus]
	@BillId int,
	@Status tinyint
AS
BEGIN
	UPDATE [BillMaster] SET
          
           [Status] = @Status
           	
	WHERE [BillId]=@BillId
END


GO
/****** Object:  StoredProcedure [dbo].[sp_BillDetail_GetAllByBillId]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_BillDetail_GetAllByBillId]
@BillId int
AS
BEGIN
SELECT b.[BillId]
      ,b.[ItemId]
	  ,i.[Name]
      ,b.[Quantity]
      ,b.[Rate]
	  ,(b.[Quantity]*b.[Rate]) AS [TotalPrice]
  FROM [BillDetail] b INNER JOIN [ItemMaster] i
  ON b.[ItemId]=i.[ItemId]
  WHERE [BillId]=@BillId
END
GO
/****** Object:  StoredProcedure [dbo].[sp_BillDetail_GetByBillId]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_BillDetail_GetByBillId]
@BillId int
AS
BEGIN
SELECT [BillId]
      ,[ItemId]
      ,[Quantity]
      ,[Rate]
  FROM [BillDetail]
  WHERE [BillId]=@BillId
END


GO
/****** Object:  StoredProcedure [dbo].[sp_BillDetail_Insert]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_BillDetail_Insert]
		@BillId int,
		@ItemId int,
		@Quantity int,
		@Rate float
AS
BEGIN
	INSERT INTO [dbo].[BillDetail]
           ([BillId]
		   ,[ItemId]
           ,[Quantity]
           ,[Rate])
     VALUES
        (@BillId,
		@ItemId,
		@Quantity,
		@Rate)
END


GO
/****** Object:  StoredProcedure [dbo].[sp_BillDetail_Update]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_BillDetail_Update]
		@BillId int,
		@ItemId int,
		@Quantity int,
		@Rate float
AS
BEGIN
	UPDATE [BillDetail] SET
           [ItemId]=@ItemId
           ,[Quantity]=@Quantity
           ,[Rate]=@Rate
	WHERE [BillId]=@BillId
END


GO
/****** Object:  StoredProcedure [dbo].[sp_Department_GetByAll]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_Department_GetByAll]
AS
BEGIN	
	SELECT [DepartmentId]
      ,[Name]
      ,[Status]
	FROM [DepartmentMaster]
END


GO
/****** Object:  StoredProcedure [dbo].[sp_Department_GetById]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_Department_GetById]
	@DepartmentId int
AS
BEGIN	
	SELECT [DepartmentId]
      ,[Name]
      ,[Status]
	FROM [DepartmentMaster]
	WHERE [DepartmentId]=@DepartmentId
END


GO
/****** Object:  StoredProcedure [dbo].[sp_Department_GetByStatus]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_Department_GetByStatus]
	@Status tinyint
AS
BEGIN	
	SELECT [DepartmentId]
      ,[Name]
      ,[Status]
	FROM [DepartmentMaster]
	WHERE [Status]=@Status
END


GO
/****** Object:  StoredProcedure [dbo].[sp_Department_Insert]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_Department_Insert]
		@Name nvarchar(100),
		@Status tinyint
AS
BEGIN
	INSERT INTO [DepartmentMaster]
           ([Name]
           ,[Status])
     VALUES
           (@Name,
           @Status)
END


GO
/****** Object:  StoredProcedure [dbo].[sp_Department_Update]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_Department_Update]
		@DepartmentId int,
		@Name nvarchar(100),
		@Status tinyint
AS
BEGIN
UPDATE [DepartmentMaster]
   SET [Name] = @Name
      ,[Status] = @Status
 WHERE [DepartmentId]=@DepartmentId
END


GO
/****** Object:  StoredProcedure [dbo].[sp_Employee_ChangePassword]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_Employee_ChangePassword]
	@EmployeeId int,
	@Password nvarchar(40)
AS
BEGIN
	UPDATE [dbo].[EmployeeMaster] SET
           [Password]=@Password
	WHERE EmployeeId = @EmployeeId
END


GO
/****** Object:  StoredProcedure [dbo].[sp_Employee_ForgotPassword]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_Employee_ForgotPassword]
@Username nvarchar(50),
@Email nvarchar(100)
AS
BEGIN
	SELECT TOP 1 [EmployeeId]
      ,[DepartmentId]
      ,[Username]
      ,[Password]
      ,[FullName]
      ,[Address]
      ,[Phone]
      ,[Email]
      ,[Status]
      ,[Role]
	FROM [EmployeeMaster]
	WHERE [Username] = @Username AND [Email] = @Email 
END

GO
/****** Object:  StoredProcedure [dbo].[sp_Employee_GetByAll]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_Employee_GetByAll]
AS
BEGIN
	SELECT [EmployeeId]
      ,[DepartmentId]
      ,[Username]
      ,[Password]
      ,[FullName]
      ,[Address]
      ,[Phone]
      ,[Email]
      ,[Status]
      ,[Role]
	FROM [EmployeeMaster]
END


GO
/****** Object:  StoredProcedure [dbo].[sp_Employee_GetById]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_Employee_GetById]
@Id int
AS
BEGIN
	SELECT [EmployeeId]
      ,[DepartmentId]
      ,[Username]
      ,[Password]
      ,[FullName]
      ,[Address]
      ,[Phone]
      ,[Email]
      ,[Status]
      ,[Role]
	FROM [EmployeeMaster]
	WHERE EmployeeId = @Id
END


GO
/****** Object:  StoredProcedure [dbo].[sp_Employee_GetByLogin]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_Employee_GetByLogin]
@Username nvarchar(50),
@Password nvarchar(40)
AS
BEGIN
	SELECT TOP 1 [EmployeeId]
      ,[DepartmentId]
      ,[Username]
      ,[Password]
      ,[FullName]
      ,[Address]
      ,[Phone]
      ,[Email]
      ,[Status]
      ,[Role]
	FROM [EmployeeMaster]
	WHERE [Username] = @Username AND [Password] = @Password 
END


GO
/****** Object:  StoredProcedure [dbo].[sp_Employee_Insert]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_Employee_Insert]
	@DepartmentId int,
	@Username nvarchar(30),
	@Password nvarchar(40),
	@FullName nvarchar(50),
	@Address nvarchar(100),
	@Phone nvarchar(15),
	@Email nvarchar(100),
	@Status tinyint,
	@Role tinyint
AS
BEGIN
	INSERT INTO [dbo].[EmployeeMaster]
           ([DepartmentId]
           ,[Username]
           ,[Password]
           ,[FullName]
           ,[Address]
           ,[Phone]
           ,[Email]
           ,[Status]
           ,[Role])
     VALUES
		(@DepartmentId,
		@Username,
		@Password,
		@FullName,
		@Address,
		@Phone,
		@Email,
		@Status,
		@Role)
END


GO
/****** Object:  StoredProcedure [dbo].[sp_Employee_Update]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_Employee_Update]
	@Id int,
	@DepartmentId int,
	@Username nvarchar(30),
	@Password nvarchar(40),
	@FullName nvarchar(50),
	@Address nvarchar(100),
	@Phone nvarchar(15),
	@Email nvarchar(100),
	@Status tinyint,
	@Role tinyint
AS
BEGIN
	UPDATE [dbo].[EmployeeMaster] SET
           [DepartmentId]=@DepartmentId
           ,[Username]=@Username
           ,[Password]=@Password
           ,[FullName]=@FullName
           ,[Address]=@Address
           ,[Phone]=@Phone
           ,[Email]=@Email
           ,[Status]=@Status
           ,[Role]=@Role
	WHERE EmployeeId = @Id
END


GO
/****** Object:  StoredProcedure [dbo].[sp_FeedBack_GetByAll]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_FeedBack_GetByAll]
AS
BEGIN
	SELECT [FeedBackId]
      ,[EmployeeId]
      ,[Title]
      ,[Date]
      ,[Message]
      ,[Status]
	FROM [dbo].[FeedBack]
END


GO
/****** Object:  StoredProcedure [dbo].[sp_FeedBack_GetById]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_FeedBack_GetById]
@EmployeeId int
AS
BEGIN
	SELECT [FeedBackId]
      ,[EmployeeId]
      ,[Title]
      ,[Date]
      ,[Message]
      ,[Status]
	FROM [dbo].[FeedBack]
	WHERE [EmployeeId] = @EmployeeId
END


GO
/****** Object:  StoredProcedure [dbo].[sp_FeedBack_GetByStatus]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_FeedBack_GetByStatus]
@Status int
AS
BEGIN
	SELECT [FeedBackId]
      ,[EmployeeId]
      ,[Title]
      ,[Date]
      ,[Message]
      ,[Status]
	FROM [dbo].[FeedBack]
	WHERE [Status] = @Status
END


GO
/****** Object:  StoredProcedure [dbo].[sp_FeedBack_Insert]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_FeedBack_Insert]
	@EmployeeId int,
	@Title nvarchar(200),
	@Date datetime,
	@Message nvarchar(max),
	@Status tinyint
AS
BEGIN
	INSERT INTO [dbo].[FeedBack]
           ([EmployeeId]
           ,[Title]
           ,[Date]
           ,[Message]
           ,[Status])
     VALUES
			(@EmployeeId,
			@Title,
			@Date,
			@Message,
			@Status)
END


GO
/****** Object:  StoredProcedure [dbo].[sp_FeedBack_Update]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_FeedBack_Update]
	@FeedBackId int,
	@EmployeeId int,
	@Title nvarchar(200),
	@Date datetime,
	@Message nvarchar(max),
	@Status tinyint
AS
BEGIN
	UPDATE [FeedBack] SET
           [EmployeeId]=@EmployeeId
           ,[Title]=@Title
           ,[Date]=@Date
           ,[Message]=@Message
           ,[Status]=@Status
	WHERE FeedBackId = @FeedBackId
END


GO
/****** Object:  StoredProcedure [dbo].[sp_Item_GetByAll]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_Item_GetByAll]
AS
BEGIN
	SELECT [ItemId]
      ,[Name]
      ,[Image]
      ,[ItemTypeId]
      ,[Rate]
      ,[Quantity]
      ,[Special]
      ,[Status]
	FROM [ItemMaster]
END


GO
/****** Object:  StoredProcedure [dbo].[sp_Item_GetById]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_Item_GetById]
@ItemId int
AS
BEGIN
	SELECT [ItemId]
      ,[Name]
      ,[Image]
      ,[ItemTypeId]
      ,[Rate]
      ,[Quantity]
      ,[Special]
      ,[Status]
	FROM [ItemMaster]
	WHERE ItemId = @ItemId
END


GO
/****** Object:  StoredProcedure [dbo].[sp_Item_GetByStatus]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_Item_GetByStatus]
@Status tinyint
AS
BEGIN
	SELECT [ItemId]
      ,[Name]
      ,[Image]
      ,[ItemTypeId]
      ,[Rate]
      ,[Quantity]
      ,[Special]
      ,[Status]
	FROM [ItemMaster]
	WHERE [Status] = @Status
END


GO
/****** Object:  StoredProcedure [dbo].[sp_Item_Insert]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_Item_Insert]
			@Name nvarchar(100),
			@Image nvarchar(50),
			@ItemTypeId int,
			@Rate float,
			@Quantity int,
			@Special tinyint,
			@Status tinyint
AS
BEGIN
	INSERT INTO [dbo].[ItemMaster]
           ([Name]
           ,[Image]
           ,[ItemTypeId]
           ,[Rate]
           ,[Quantity]
           ,[Special]
           ,[Status])
     VALUES
           (@Name,
			@Image,
			@ItemTypeId,
			@Rate,
			@Quantity,
			@Special,
			@Status)
END


GO
/****** Object:  StoredProcedure [dbo].[sp_Item_Update]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_Item_Update]
			@ItemId int,
			@Name nvarchar(100),
			@Image nvarchar(50),
			@ItemTypeId int,
			@Rate float,
			@Quantity int,
			@Special tinyint,
			@Status tinyint
AS
BEGIN
	UPDATE [dbo].[ItemMaster] SET
           [Name]=@Name
           ,[Image]=@Image
           ,[ItemTypeId]=@ItemTypeId
           ,[Rate]=@Rate
           ,[Quantity]=@Quantity
           ,[Special]=@Special
           ,[Status]=@Status
	WHERE [ItemId] = @ItemId
END


GO
/****** Object:  StoredProcedure [dbo].[sp_ItemType_GetByAll]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_ItemType_GetByAll]
AS
BEGIN
	SELECT [ItemTypeId]
      ,[Name]
      ,[Status]
	FROM [dbo].[ItemTypeMaster]
END


GO
/****** Object:  StoredProcedure [dbo].[sp_ItemType_GetById]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_ItemType_GetById]
@ItemTypeId int
AS
BEGIN
	SELECT [ItemTypeId]
      ,[Name]
      ,[Status]
	FROM [dbo].[ItemTypeMaster]
	WHERE [ItemTypeId] = @ItemTypeId
END


GO
/****** Object:  StoredProcedure [dbo].[sp_ItemType_GetByStatus]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_ItemType_GetByStatus]
@Status tinyint
AS
BEGIN
	SELECT [ItemTypeId]
      ,[Name]
      ,[Status]
	FROM [dbo].[ItemTypeMaster]
	WHERE [Status] = @Status
END


GO
/****** Object:  StoredProcedure [dbo].[sp_ItemType_Insert]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_ItemType_Insert]
@Name nvarchar(100),
@Status tinyint
AS
BEGIN
INSERT INTO [ItemTypeMaster] ([Name] ,[Status]) VALUES (@Name, @Status)
END


GO
/****** Object:  StoredProcedure [dbo].[sp_ItemType_Update]    Script Date: 12/31/2014 4:15:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_ItemType_Update]
@ItemTypeId int,
@Name nvarchar(100),
@Status tinyint
AS
BEGIN
UPDATE [ItemTypeMaster] SET [Name]=@Name ,[Status]=@Status WHERE [ItemTypeId]=@ItemTypeId
END

GO
