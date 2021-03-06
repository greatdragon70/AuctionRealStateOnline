USE [Auction]
GO
/****** Object:  Table [dbo].[AdminManagement]    Script Date: 12/07/2018 10:07:52 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AdminManagement](
	[fullname] [varchar](50) NOT NULL,
	[age] [int] NOT NULL,
	[gmail] [varchar](50) NOT NULL,
	[addressUser] [varchar](50) NOT NULL,
	[phone] [varchar](11) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[passwordUser] [varchar](50) NOT NULL,
	[nationality] [varchar](25) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[person]    Script Date: 12/07/2018 10:07:52 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[person](
	[fullname] [varchar](50) NOT NULL,
	[age] [int] NOT NULL,
	[gmail] [varchar](50) NOT NULL,
	[addressUser] [varchar](50) NOT NULL,
	[phone] [varchar](11) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[passwordUser] [varchar](50) NOT NULL,
	[nationality] [varchar](25) NOT NULL,
	[statement] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[product]    Script Date: 12/07/2018 10:07:52 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product](
	[id] [int] NOT NULL,
	[imageURL] [varchar](255) NULL,
	[nameProduct] [varchar](50) NOT NULL,
	[infoProduct] [varchar](255) NOT NULL,
	[price] [varchar](255) NOT NULL,
	[fullname] [varchar](50) NULL,
	[username] [varchar](50) NOT NULL,
	[DateT] [date] NULL,
	[Dtime] [time](0) NULL,
	[newMoney] [int] NULL,
	[clock] [int] NULL,
	[audition_price] [int] NULL,
	[numberOfAuction] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[productBought]    Script Date: 12/07/2018 10:07:52 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[productBought](
	[id] [int] NOT NULL,
	[imageURL] [varchar](255) NOT NULL,
	[nameProduct] [varchar](50) NOT NULL,
	[infoProduct] [varchar](255) NOT NULL,
	[price] [varchar](255) NOT NULL,
	[fullname] [varchar](50) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[DateT] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Recharge]    Script Date: 12/07/2018 10:07:52 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Recharge](
	[series] [varchar](12) NOT NULL,
	[code] [varchar](12) NOT NULL,
	[money] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[code] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserManagement]    Script Date: 12/07/2018 10:07:52 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserManagement](
	[username] [varchar](50) NOT NULL,
	[imageURL] [varchar](255) NOT NULL,
	[moneyUser] [int] NULL,
	[rankUser] [varchar](20) NOT NULL,
	[topUser] [int] NOT NULL,
	[point] [int] NOT NULL,
	[totalMoney] [int] NULL,
	[moneySpent] [int] NULL,
	[fullname] [varchar](50) NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[product]  WITH CHECK ADD FOREIGN KEY([username])
REFERENCES [dbo].[person] ([username])
GO
ALTER TABLE [dbo].[productBought]  WITH CHECK ADD FOREIGN KEY([username])
REFERENCES [dbo].[person] ([username])
GO
ALTER TABLE [dbo].[UserManagement]  WITH CHECK ADD FOREIGN KEY([username])
REFERENCES [dbo].[person] ([username])
GO
