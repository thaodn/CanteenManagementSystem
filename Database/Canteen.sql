/* Begin create database */
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
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DepartmentMaster](
	[DepartmentId] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](100) NULL,
	[Status] [bit] NULL,
 CONSTRAINT [PK_DepartmentMaster] PRIMARY KEY CLUSTERED 
(
	[DepartmentId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[EmployeeMaster]    Script Date: 12/12/2014 11:41:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EmployeeMaster](
	[EmployeeId] [int] IDENTITY(1,1) NOT NULL,
	[DepartmentId] [int] NOT NULL,
	[Username] [nvarchar](30) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
	[FullName] [nvarchar](50) NULL,
	[Address] [nvarchar](100) NULL,
	[Phone] [nvarchar](15) NULL,
	[Email] [nvarchar](100) NULL,
	[Status] [bit] NOT NULL,
	[Role] [int] NOT NULL,
 CONSTRAINT [PK_EmployeeMaster] PRIMARY KEY CLUSTERED 
(
	[EmployeeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[FeedBack]    Script Date: 12/12/2014 11:41:04 AM ******/
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
	[Status] [bit] NOT NULL,
 CONSTRAINT [PK_FeedBack] PRIMARY KEY CLUSTERED 
(
	[FeedBackId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ItemMaster]    Script Date: 12/12/2014 11:41:04 AM ******/
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
	[Special] [bit] NULL,
	[Status] [bit] NULL,
 CONSTRAINT [PK_ItemMaster] PRIMARY KEY CLUSTERED 
(
	[ItemId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ItemTypeMaster]    Script Date: 12/12/2014 11:41:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ItemTypeMaster](
	[ItemTypeId] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](100) NULL,
	[Status] [bit] NULL,
 CONSTRAINT [PK_ItemTypeMaster] PRIMARY KEY CLUSTERED 
(
	[ItemTypeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 12/12/2014 11:41:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[OrderId] [int] IDENTITY(1,1) NOT NULL,
	[ItemId] [int] NOT NULL,
	[Quantity] [int] NULL,
	[Rate] [float] NULL,
 CONSTRAINT [PK_OrderDetail] PRIMARY KEY CLUSTERED 
(
	[OrderId] ASC,
	[ItemId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[OrderMaster]    Script Date: 12/12/2014 11:41:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderMaster](
	[OrderId] [int] IDENTITY(1,1) NOT NULL,
	[OrderDate] [datetime] NULL,
	[CoupenNo] [nvarchar](50) NOT NULL,
	[CoupenDate] [datetime] NULL,
	[OrderInfo] [nvarchar](50) NULL,
	[EmployeeId] [int] NOT NULL,
	[Status] [bit] NOT NULL,
 CONSTRAINT [PK_OrderMaster] PRIMARY KEY CLUSTERED 
(
	[OrderId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

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
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_ItemMaster] FOREIGN KEY([ItemId])
REFERENCES [dbo].[ItemMaster] ([ItemId])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_OrderDetail_ItemMaster]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_OrderMaster] FOREIGN KEY([OrderId])
REFERENCES [dbo].[OrderMaster] ([OrderId])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_OrderDetail_OrderMaster]
GO
ALTER TABLE [dbo].[OrderMaster]  WITH CHECK ADD  CONSTRAINT [FK_OrderMaster_EmployeeMaster] FOREIGN KEY([EmployeeId])
REFERENCES [dbo].[EmployeeMaster] ([EmployeeId])
GO
ALTER TABLE [dbo].[OrderMaster] CHECK CONSTRAINT [FK_OrderMaster_EmployeeMaster]
GO
